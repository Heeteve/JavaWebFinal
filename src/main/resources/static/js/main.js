// JWT解码
function jwtParser(token) {
    const base64 = token.split('.')[1];
    const base64r = base64.replace(/-/g, '+').replace(/_/g, '/');
    return JSON.parse(decodeURIComponent(atob(base64r)));
}

function fetchUid() {
    const jwt = localStorage.getItem('jwt');
    if (jwt) {
        let userinfo = jwtParser(jwt);
        console.log(userinfo);
        return userinfo.id;
    } else {
        return 0;
    }
}