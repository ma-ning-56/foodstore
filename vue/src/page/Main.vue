<template>
  <div>
    <el-container>
      <el-header style="padding-left:0px;padding-right: 0px;">
        <el-menu
          :default-active="activeIndex2"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
          <el-menu-item index="1">主页</el-menu-item>
          <el-submenu index="2">
            <template slot="title">商品</template>
            <el-menu-item index="2-1">熟</el-menu-item>
            <el-menu-item index="2-2">生</el-menu-item>
            <el-submenu index="2-3">
              <template slot="title">其他</template>
              <el-menu-item index="2-3-1">杂</el-menu-item>
              <el-menu-item index="2-3-2">选项2</el-menu-item>
              <el-menu-item index="2-3-3">选项3</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-menu-item index="4">公告</el-menu-item>
          <el-menu-item index="3" style="left: 1200px">登录</el-menu-item>
        </el-menu>
      </el-header>
      <el-main>
          <el-carousel :interval="4000" type="card" height="350px">
            <el-carousel-item v-for="item in 6" :key="item">
              <h3 class="medium">{{ item }}</h3>
            </el-carousel-item>
          </el-carousel>
          <c-card></c-card>
      </el-main>
      <el-footer>测试版本</el-footer>
    </el-container>
  </div>
</template>
<script>
// import CTable from './content/c-table'
import CCard from './content/c-card'
export default {
  name: 'Main',
  data () {
    return {
      activeIndex2: '1'
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
      if (key=='3'){
        this.$router.push({ path: '/login' })
      }
    }
  },
  components: {
    CCard
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }

  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>
