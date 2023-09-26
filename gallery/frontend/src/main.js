import { createApp } from 'vue'
import store from './scripts/store';
import App from './App.vue'
import router from './scripts/router';



createApp(App).use(store).use(router).mount('#app')
