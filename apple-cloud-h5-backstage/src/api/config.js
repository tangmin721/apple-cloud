export const pageParams = {
  currentPage: 1,
  pageSize: 10
}

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
