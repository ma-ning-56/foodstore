<template>
  <div class="homepage-hero-module">
    <div class="video-container">
      <div :style="fixStyle" class="filter">
        <div class="login-container">
          <el-form :model="ruleForm2" :rules="rules2"
                   status-icon
                   ref="ruleForm2"
                   label-position="left"
                   label-width="0px"
                   class="demo-ruleForm login-page">
            <h3 class="title">Food Store</h3>
            <el-form-item prop="username">
              <el-input type="text"
                        v-model="ruleForm2.username"
                        auto-complete="off"
                        placeholder="用户名"
              ></el-input>
            </el-form-item>
            <el-form-item prop="password">
              <el-input type="password"
                        v-model="ruleForm2.password"
                        auto-complete="off"
                        placeholder="密码"
              ></el-input>
            </el-form-item>
            <el-checkbox
              v-model="checked"
              class="rememberme"
            >记住密码</el-checkbox>
            <el-form-item style="width:100%;">
              <el-button type="primary" style="width:100%;" @click="handleSubmit" :loading="logining">登录</el-button>
              <ul class="account-list">
                <li>
                  <a href="https://github.com/login/oauth/authorize?client_id=bbb5cc2034eb62484c1c&state=github" style="{right: 26px;}">
                    <!-- <Icon  style="color: rebeccapurple;" size="40" type="social-github"></Icon> -->
                    <img class="icon" src="/static/img/GitHub.svg" />
                  </a>
                </li>

                <li>
                  <a href="https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=101512648&redirect_uri=http://www.lovemtt.com/qq&state=qq" style="{right: 26px;}">
                    <img class="icon" src="/static/img/social-qq.svg" />
                  </a>
                </li>
              </ul>
            </el-form-item>
          </el-form>
        </div>
      </div>
      <video :style="fixStyle" autoplay loop class="fillWidth" v-on:canplay="canplay">
        <source src="/static/img/PATH_TO_MP4.mp4" type="video/mp4"/>
        浏览器不支持 video 标签，建议升级浏览器。
        <source src="PATH_TO_WEBM" type="video/webm"/>
        浏览器不支持 video 标签，建议升级浏览器。
      </video>
      <div class="poster hidden" v-if="!vedioCanPlay">
        <img :style="fixStyle" src="/static/img/PATH_TO_JPEG.jpg" alt="">
      </div>
    </div>
  </div>
</template>
<script>

import foodstoreApi from "../../api/foodstoreApi";

export default {
    name: 'login',
    data() {
      return {
        vedioCanPlay: false,
        fixStyle: '',
        logining: false,
        ruleForm2: {
          username: 'admin',
          password: '',
        },
        rules2: {
          username: [{required: true, message: 'please enter your account', trigger: 'blur'}],
          password: [{required: true, message: 'enter your password', trigger: 'blur'}]
        },
        checked: false
      }
    },
    methods: {
      canplay () {
        this.vedioCanPlay = true
      },
      handleSubmit (event) {
        this.$refs.ruleForm2.validate((valid) => {
          if (valid) {
            this.logining = true;
            foodstoreApi.api.queryUserCfg(this.ruleForm2.username).then(res=>{
              console.log("denglu",res);
              if (this.ruleForm2.username === res.data.username &&
                this.ruleForm2.password === res.data.password) {
                this.logining = false;
                sessionStorage.setItem('user', this.ruleForm2.username);
                this.$router.push({path: '/'});
              } else {
                this.logining = false;
                this.$message({
                  type: 'error',
                  message: '用户名或密码错误',
                  showClose: true
                })
              }
            });
          } else {
            console.log('error submit!');
            return false;
          }
        })
      }
    },
    mounted: function() {
      window.onresize = () => {
        const windowWidth = document.body.clientWidth
        const windowHeight = document.body.clientHeight
        const windowAspectRatio = windowHeight / windowWidth
        let videoWidth
        let videoHeight
        if (windowAspectRatio < 0.5625) {
          videoWidth = windowWidth
          videoHeight = videoWidth * 0.5625
          this.fixStyle = {
            height: windowWidth * 0.5625 + 'px',
            width: windowWidth + 'px',
            'margin-bottom': (windowHeight - videoHeight) / 2 + 'px',
            'margin-left': 'initial'
          }
        } else {
          videoHeight = windowHeight
          videoWidth = videoHeight / 0.5625
          this.fixStyle = {
            height: windowHeight + 'px',
            width: windowHeight / 0.5625 + 'px',
            'margin-left': (windowWidth - videoWidth) / 2 + 'px',
            'margin-bottom': 'initial'
          }
        }
      }
      window.onresize()
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .homepage-hero-module,
  .video-container {
    position: relative;
    height: 100vh;
    overflow: hidden;
  }

  .video-container .poster img,
  .video-container video {
    z-index: 0;
    position: absolute;
  }

  .video-container .filter {
    z-index: 1;
    position: absolute;
    background: rgba(0, 0, 0, 0.4);
  }

  .login-container {
    width: 100%;
    height: 100%;

  }
  .login-page {

    -webkit-border-radius: 5px;
    border-radius: 5px;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  label.el-checkbox.rememberme {
    margin: 0px 0px 15px;
    text-align: left;
  }
  .homeBox {
    position: fixed;
    width: 100%;
    height: 100%;
    top: 0px;
    left: 0px;
    background-color: #409EFF;
  }
  .account-list li {
    width: auto;
    display: inline-block;
    padding-left: 75px;
  }
  .account-list .icon {
    width: 35px;
    height: 40px;
  }
</style>
