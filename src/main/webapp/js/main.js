// JWT解码
function jwtParser(token) {
    const base64Url = token.split('.')[1];
    const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    const jsonPayload = decodeURIComponent(atob(base64).split('').map(function (c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));
    return JSON.parse(jsonPayload);
}

function fetchUid() {
    const jwt = localStorage.getItem('jwt');
    if (jwt) {
        let userinfo = jwtParser(jwt);
        console.log(userinfo);
        this.uid = userinfo.id;
    }
}