<template>
	<div class="my-index" style="display: flex; margin: auto;">
		<el-container>
			
			<el-header>
				<h1 class="head-title">
					HIS医院管理系统
				</h1>
			</el-header>
			
			<el-main style="display: flex; flex-direction: column; align-items: center; justify-content: center;">
	<el-form-item class="my-button" style="width: 100%; ">
		<el-button type="primary" class="btn-center" size="large" @click='doAdd()' color="#1F4FA3">门诊挂号收费站</el-button>&nbsp;&nbsp;&nbsp;&nbsp;
		<el-button type="primary" class="btn-center" size="large" @click='toODW()' color="#1F4FA3">门诊医生工作站</el-button>&nbsp;&nbsp;&nbsp;&nbsp;
		<el-button type="primary" class="btn-center" size="large" @click='doAdd()' color="#1F4FA3">门诊医技工作站</el-button>&nbsp;&nbsp;&nbsp;&nbsp;
		<el-button type="primary" class="btn-center" size="large" @click='todrugquery()' color="#1F4FA3">门诊药房工作站</el-button>&nbsp;&nbsp;&nbsp;&nbsp;
		<el-button type="primary" class="btn-center" size="large" @click='toAdd()' color="#1F4FA3">门诊财务管理站</el-button><br />
		
	</el-form-item>
	<el-calendar v-model="value" />
	</el-main>
	
	
	</el-container>
	</div>
</template>

<script setup>
	
	import axios from 'axios'
	import qs from 'qs'
	import {
		useRouter
	} from 'vue-router'
	import {
		ref,
		inject
	} from 'vue'
	import {
		h
	} from 'vue'
	import {
		ElMessage
	} from 'element-plus'
	

	
	const router = useRouter();
	
	const value = ref(new Date())
	
	const todrugquery = () => {
		router.push('/drugquery')
	}
	
		
	const toODW = () =>{		
		router.push('/OutpatientDiagnosis')
	}
</script>

<style scoped="scoped">
	.my-index {
		width: 100%;
		height: 100%;
		display: flex;
		flex-direction: column;
	}
	header {
		height: 40px;
		background-image: url(../assets/logo.jpg);
		background-size: 100% 100%;
	}
	
	main {
		width: 100%;
		display: flex;

		background-size: 100%;
		}
		.my-button {
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
		}
		.head-title{
			color: white;
			font-size: 30px;
		}
</style>
