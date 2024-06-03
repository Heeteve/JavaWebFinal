<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>商城 - 登录</title>
    <link rel="stylesheet" href="css/login.css">
<!--    <script src="https://unpkg.com/vue@2.6"></script>-->
    <script src="import/vue.js"></script>
<!--    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>-->
    <script src="import/axios.min.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
</head>

<body>
    <div id="login" class="login">
        <h1>Login</h1>
        <form @submit.prevent="login">
                <input type="text" placeholder="用户名" id="username" v-model="username" required >
                <input type="password" placeholder="密码" id="password" v-model="password" required>
            <button type="submit">Login</button>
        </form>
    </div>

    <script>
        new Vue({
            el: '#login',
            data: {
                username: '',
                password: '',
                errorMessage: ''
            },
            methods: {
                login() {
                    const params = new URLSearchParams();
                    params.append('username', this.username);
                    params.append('password', this.password);

                    axios.post('/login', params)
                        .then(response => {
                            const result = response.data;
                            if (result.code === 1) {
                                this.$message.success('登录成功');
                                console.log(response.data);
                                const jwt = response.data.data;
                                localStorage.setItem('jwt', jwt);
                                // 配置请求头
                                let token = localStorage.getItem('jwt');
                                if (token) {
                                    console.log(token);
                                    axios.defaults.headers.common['token'] = token;
                                }
                                window.location.href = 'product';
                            } else {
                                this.$message.error(result.msg);
                            }
                        })
                }
            }
        });
    </script>
    
    <script>
        let login = document.querySelector('.login');
        let effect;

        login.addEventListener('mouseenter', function (e) {
            effect = document.createElement('span')
            login.appendChild(effect);
            effect.style.animation = 'mouse-in .5s ease-in-out forwards';
            // 计算进入位置
            let top = e.clientY - e.target.offsetTop;
            let left = e.clientX - e.target.offsetLeft;
            effect.style.top = top +'px';
            effect.style.left = left +'px';
        })

        login.addEventListener('mouseleave', function (e) {
            effect.style.animation = 'mouse-out .5s ease-in-out forwards';
            // 计算离开位置
            let top = e.clientY - e.target.offsetTop;
            let left = e.clientX - e.target.offsetLeft;
            effect.style.top = top +'px';
            effect.style.left = left +'px';
        })
    </script>
</body>

</html>