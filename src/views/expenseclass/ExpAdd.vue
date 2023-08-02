<template>
	<div>
		<h1>费用科目增加</h1>
		<p v-text="msg" style="color: red;"></p ><br><br />
		
		<table width="60%" border="1" style="margin: 0 auto;">
			<tr>
				<td>编号</td>
				<td>
					<input v-model="expenseclass.ExpCode" />
				</td>
			</tr>
			<tr>
				<td>费用科目</td>
				<td>
					<input v-model="expenseclass.ExpName" />
				</td>
			</tr>
		
			<tr>
				<td colspan="2">
					<button @click="doAdd()">增加完成</button>
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
	import {useRouter} from 'vue-router'
	const router = useRouter();
	
	const expenseclass = ref({
		ExpCode:'',
		ExpName:'',
	});
	const msg = ref('');
	
	const doAdd = ()=>{
			if(expenseclass.value.ExpCode.length==0){
				alert('不能为空');
				return false;
			}

		let url='/expenseclass/add';
		axios.post(url, qs.stringify(expenseclass.value))
			.then((resp)=>{
				let data = resp.data;
				console.log('expCode=',expenseclass.value.ExpCode);
				if(data>0){
					msg.value='add ok'
				}else{
					msg.value='增加失败，请联系管理员处理！'
				}
			})
			.catch((err)=>{console.log('err=', err);});
	}
	
	const toAdd=()=>{
		
	}
</script>

<style>
</style>