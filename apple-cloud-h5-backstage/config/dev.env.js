'use strict';
const merge = require('webpack-merge');
const prodEnv = require('./prod.env');

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  API_LOCAL: '"https://localhost:80"',
  API_DEV: '"http://localhost:80"',
  API_TEST: '"https://api.guoanyunfu.cn"',
  API_PROD: '"https://api.guoanyunfu.com"'
});
