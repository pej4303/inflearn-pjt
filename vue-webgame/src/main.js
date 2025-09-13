import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'

const app = createApp(App)
app.use(createPinia())
app.use(router)   // 라우터 등록
app.mount('#app') // index.html에 #root으로 mount
