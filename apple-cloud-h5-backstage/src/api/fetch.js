import axios from 'axios'
import config from '../env';
import { Message } from 'element-ui'

// 操作成功
export const RES_OK = 0
// 操作失败
export const RES_FAIL = -1
// 找不到纪录,返回list为空
export const RES_EMPTY = 1
// 数据校验失败
export const RES_VALID_ERROR = 2
// 身份校验失败,请重新登录
export const RES_UNAUTHORIZED = 3

// sessionStorage 存储
export const TOKEN_KEY = 'backstage:token'
export const REFRESH_TOKEN_KEY = 'backstage:refresh_token'

var api = axios.create({
  baseURL: process.env.API_LOCAL,
  timeout: 5000,
  headers: {'X-Custom-Header': 'foobar'}
})

// request拦截器
api.interceptors.request.use(config => {
  // Do something before request is sent
  console.log(config.baseURL)
  if (sessionStorage) {
    const token = sessionStorage.getItem(TOKEN_KEY)
    if (token) {
      config.headers['Authorization'] = 'bearer ' + token // 让每个请求携带token--['X-Token']为自定义key 请根据实际情况自行修改
    }
    return config
  } else {
    alert('您的浏览器已经老掉牙了,请使用现代浏览器,推荐chrome')
  }
}, error => {
  console.log('error', error)
  Message({
    message: error.message,
    type: 'error',
    duration: 5 * 1000
  })
  Promise.reject(error)
})

// respone拦截器
api.interceptors.response.use(
  res => {
    res = res.data
    if (res.status === RES_OK) {
      this.list = res.data.list
      this.total = Number(res.data.total)
    } else if (res.status === RES_EMPTY) {
      this.list = []
    } else {
      Message({
        message: res.message,
        type: 'error',
        duration: 5 * 1000
      })
    }
    return res
  },
  error => {
    Message({
      message: error.message,
      type: 'error',
      duration: 5 * 1000
    })
    console.log('err' + error)
    return Promise.reject(error)
  }
)

export default api
