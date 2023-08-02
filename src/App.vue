<template>
  <router-view/>
</template>

<script setup>
//引入axios并设置其默认特性，对外提供axios对象
import {provide} from 'vue'
import axios from 'axios'
import qs from 'qs'

axios.defaults.withCredentials=true;
axios.defaults.baseURL='http://localhost:8090';//设置后端项目基本路径

provide('axios',axios);
provide('qs',qs);
	
</script>

<!-- 这里是共通样式，适用于所有组件，所以不要加scoped -->
<style>
	#app {
	  text-align: center;
	}
	html,body,div,span,h1,h2,h3,h4,h5,h6,ul,ol,li,p {
		margin: 0;
		padding: 0;
	}
	html,body,#app {
		width: 100%;
		height: 100%;
		font-family: "微软雅黑";
	}
	ul,ol {
		list-style: none;
	}
	a {
		text-decoration: none;
	}
</style>


