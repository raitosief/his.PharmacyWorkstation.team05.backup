<template>
	<div>
		<h1>费用科目修改</h1>
		<p v-text="msg" style="color: red;"></p ><br><br />
		
		<table width="60%" border="1" style="margin: 0 auto;">
			<tr>
				<td>编号</td>
				<td>
					<input v-model="expenseclass.iD" />
				</td>
			</tr>
			<tr>
				<td>费用科目编码</td>
				<td>
					<input v-model="expenseclass.expCode" />
				</td>
			</tr>
			<tr>
				<td>费用科目名称</td>
				<td>
					<input v-model="expenseclass.expName" />
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<button @click="doUpdate()">修改</button>
				</td>
			</tr>
		</table>
		
	</div>
</template>

<script setup>
	// 引入公共的模块及变量-基本是固定代码
	import {ref, inject} from 'vue'
	const axios = inject('axios');
	const qs = inject('qs');
	import {useRouter,useRoute} from 'vue-router'
	const router = useRouter();
	
	const route = useRoute();
	
	
	const expenseclass = ref(JSON.parse(route.query.u));//一会通过路由传参进行赋值
	console.log('expenseclass=',expenseclass.value);
	const msg = ref('');
	
	const doUpdate = ()=>{
		let url='/expenseclass/update';
		axios.post(url, qs.stringify(expenseclass.value))
			.then((resp)=>{
				let data = resp.data;
				console.log('data=', data);
				if(data>0){
					msg.value='update ok'
				}else{
					msg.value='修改失败，请联系管理员处理！'
				}
			})
			.catch((err)=>{console.log('err=', err);});
	}
</script>

<style>
</style>