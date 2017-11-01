import axios from 'axios'
import env from './env'
import * as apiconfig from './apiconfig'
import { Message } from 'element-ui'

const ENV = env.local
const duration = 3 * 1000

var api = axios.create({
  baseURL: ENV,
  timeout: 5000,
  headers: {'Content-Type': 'application/json'}
})

// request请求配置
api.interceptors.request.use(config => {
  if (ENV !== env.prod) {
    console.log('不是生产环境' + apiconfig.TOKEN_KEY)
  }
  if (sessionStorage) {
    const token = sessionStorage.getItem(apiconfig.TOKEN_KEY)
    if (token) {
      config.headers['Authorization'] = 'bearer ' + token // 让每个请求携带token--['X-Token']为自定义key 请根据实际情况自行修改
    }
    return config
  } else {
    Message({
      message: '您的浏览器已经老掉牙了,请使用现代浏览器',
      type: 'error',
      duration
    })
  }
}, error => {
  console.error(error)
  Message({
    message: '请求失败:' + error.message,
    type: 'error',
    duration
  })
  Promise.reject(error)
})

// respone拦截器
api.interceptors.response.use(
  response => {
    response = response.data
    if (response.status === apiconfig.RES_OK || response.status === apiconfig.RES_VALID_ERROR) {
      // 根据自身需求弹出是否成功
      return response
    } else if (response.status === apiconfig.RES_FAIL || response.status === apiconfig.RES_UNAUTHORIZED) {
      Message({
        message: response.message,
        type: 'error',
        duration
      })
    } else if (response.status === apiconfig.RES_EMPTY) {

    }
    // 使得调用方获取不到响应结果
    return Promise.reject(response)
  },
  error => {
    let errorMsg = '响应失败:' + error.message
    const errorStatus = error.status
    switch (errorStatus) {
      case 401:
        errorMsg = '身份认证失败:' + errorMsg
        break
      case 403:
        errorMsg = '您没有权限操作此功能:' + errorMsg
        break
      default:
        errorMsg = '错误码:' + errorStatus + '错误原因:' + errorMsg
    }
    console.error(errorMsg)

    Message({
      message: errorMsg,
      type: 'error',
      duration
    })
    return Promise.reject(error)
  }
)

export default api
