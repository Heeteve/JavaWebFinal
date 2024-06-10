// JWT解码
function jwtParser(token) {
    let base64 = token.split('.')[1];
    base64 = base64.replace(/-/g, '+').replace(/_/g, '/');
    return JSON.parse(decodeURIComponent(atob(base64)));
}

function fetchUid() {
    const jwt = getCookie('jwt');
    if (jwt) {
        const userinfo = jwtParser(jwt);
        return userinfo.id;
    } else {
        return 0;
    }
}

function fetchRole() {
    const jwt = getCookie('jwt');
    if (jwt) {
        const userinfo = jwtParser(jwt);
        return userinfo.role;
    } else {
        return 0;
    }
}

function getCookie(cookieName) {
    const strCookie = document.cookie
    const cookieList = strCookie.split(';')
    for (let i = 0; i < cookieList.length; i++) {
        const arr = cookieList[i].split('=')
        if (cookieName === arr[0].trim()) {
            return arr[1]
        }
    }
    return ''
}

function logout(){
    // 清除jwt
    document.cookie = 'jwt=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
    window.location.href = '/login.html';
}