export const pageParams = {
  currentPage: 1,
  pageSize: 10
}

// 操作成功
export const RESULT_OK = 0
// 操作失败
export const RESULT_FAIL = -1
// 找不到纪录,返回list为空
export const RESULT_EMPTY = 1
// 数据校验失败
export const RESULT_VALID_ERROR = 2
// 身份校验失败,请重新登录
export const RESULT_UNAUTHORIZED = 3
