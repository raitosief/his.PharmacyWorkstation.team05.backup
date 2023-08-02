<template>
	<div>
		<h1>费用科目信息</h1>
		<p v-text="msg" style="color: red;"></p ><br><br />
	
		<el-form class="my-form" style="width: 96%; margin: 0 auto;">
			<el-form-item label="费用科目">
				<el-input type="text" v-model="expenseclass.ExpName"></el-input>
				<el-button type="primary" class="btn-center" @click='doSelectAll()'>查询</el-button>
				<el-button type="info" class="btn-center" @click='toAdd()'>增加</el-button>
			</el-form-item>
			
			
			<br />
			<el-table :data="list" stripe border class="el-table" style="width: 96%;margin: 0 auto;">
				<el-table-column prop="id" label="编号" sortable></el-table-column>
				<el-table-column prop="expCode" label="费用科目编码" sortable></el-table-column>
				<el-table-column prop="expName" label="费用科目名称"></el-table-column>
				<el-table-column label="操作">
					<template #default="scope">
						<el-button type="info" @click='toUpdate(scope.row)'>修改</el-button>
						<el-button type="danger" @click='doDelete(scope.row, scope.$index)'>删除</el-button>
	
					</template>
	
				</el-table-column>
	
			</el-table>
	
		</el-form>	
	
	</div>
</template>

<script setup>
	// 引入公共的模块及变量-基本是固定代码
	import {
		ref,
		inject,
		provide
	} from 'vue'
	const axios = inject('axios');
	const qs = inject('qs');
	import {
		useRouter
	} from 'vue-router'
	const router = useRouter();
	
	const expenseclass = ref({
		ExpName: '',
	});
	const msg = ref('');
	const list = ref([]); //表示查询结果
	
	const doSelectAll = () => {
		let url = '/expenseclass/selectAll';
		axios.post(url, qs.stringify(expenseclass.value))
			.then((resp) => {
				let data = resp.data;
				list.value = data;
				console.log("data=",data);
			})
			.catch((err) => {
				console.log('err=', err);
			});
	}
	
	const toAdd = () => {
		router.push('/expenseclass/ExpAdd')
	}
	const toUpdate = (e) => {
		router.push({
			path: '/expenseclass/ExpUpdate',
			query: {
				u: JSON.stringify(e) //把对象转为字符串，然后通过路由传参
			}
		})
	}
	
	const doDelete = (e, i) => {
			if (!confirm('您确认要删除本记录吗？')) {
				return false;
			}
		
			let url = '/expenseclass/delete';
			axios.post(url, "ID="+e.id)
				.then((resp) => {
					let data = resp.data;
					
						msg.value = 'delete ok'
						//把当前list中的对应数据也删除
						list.value.splice(i, 1); //splice方法：从参数i的索引开始删除1个元素
					
				})
				.catch((err) => {
					console.log('err=', err);
				});
		}
	</script>
	
	<style>
	</style>