<template>
	<div class="main">
	 
	    
	      <el-result
	        icon="success"
	        title="成功"
	        sub-title="已成功退出门诊药房工作站"
	      >
	        <template #extra>
	          <el-button type="primary" @click='toindex()'>返回主页</el-button>
	        </template>
	      </el-result>
	
	</div>
</template>

<script setup>
	import axios from 'axios'
	import qs from 'qs'
	import {useRouter} from 'vue-router'
	import {ref,inject} from 'vue'
	import { h } from 'vue'
	import { ElMessage } from 'element-plus'
	const router = useRouter();
	const toindex = () => {
		router.push('/index')
	}
	
</script>

<style scoped="scoped">
	.main {
		width: 100%;
		height: 100%;
		display: flex;
		flex-direction: column;
	}
</style>
