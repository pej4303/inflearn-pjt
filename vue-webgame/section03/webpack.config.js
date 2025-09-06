const path = require('path');
const { VueLoaderPlugin } = require('vue-loader');

module.exports = {
    mode: 'development',
    devtool: 'eval-source-map', // 웹팩에서 사용하는 옵션
    resolve: {
        extensions: ['.js', '.vue', '.json']
    },
    entry: {
        // 핵심 파일
        app: path.join(__dirname, 'src/main.js'),
    },
    // 웹팩의 핵심
    module: {
        rules: [
            {   // vue 파일은 이제 vue-loader 가 처리함
                test: /\.vue$/,
                loader: 'vue-loader'
            },
            {
                test: /\.js$/,
                exclude: /node_modules/,
                loader: 'babel-loader'
            },
        ]
    },
    plugins: [
        new VueLoaderPlugin()
    ],
    output: {
        filename: 'app.js',
        path: path.resolve(__dirname, 'dist'),
    },
};
