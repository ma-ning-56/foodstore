import axios from "axios";

// let mp = "foodstore";


let api = {
  /**
   * 获取人员关联信息配置
   */
  // queryUserCfg: function () {
  //   return axios.get(`${mp}/api/archive/queryUserCfg`, {
  //     headers: {
  //       'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
  //     }
  //   });
  // }
  queryUserCfg: function (username) {
    return axios.post(`api/archive/queryUserCfg`, username, {
      headers: {
        'Content-Type': 'application/json',
        'loading': true
      }
    });
  }
}

export default{
  api
}
