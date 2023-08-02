<template>
	<div class="common-layout">
		<el-container>
			<el-header style="border-bottom: 1px solid #bebebe;">

				<div class="my-top" style="float: right; vertical-align: bottom; margin-right: 10px;">
					<el-link type="info" style="font-size: larger; color: white;" @click='toregister()'>挂号 </el-link>&nbsp;
					<el-link type="info" style="font-size: larger; color: white;" @click='todoc()'>门诊 </el-link>&nbsp;
					<el-link type="info" style="font-size: larger; color: white;" @click='totech()'>医技 </el-link>&nbsp;
					<el-link type="info" style="font-size: larger; color: white;" @click='todrug()'>药房 </el-link>&nbsp;
					<el-link type="info" style="font-size: larger; color: white;" @click='tofinance()'>财务 </el-link>&nbsp;
					<el-link type="danger" @click='toback()'>退出 </el-link>&nbsp;
				</div>
			</el-header>
			<el-container>
				<el-aside style="border-right: 1px solid #aaaaaa;">
					<div>
						<br /><br /><br />
						<el-link type="default" style="font-size:x-large" @click='tooutpatientdispensing()'>发药 </el-link><br /><br />
						<el-link type="default" style="font-size:x-large" @click='tooutpatientwithdrawal()'>退药 </el-link><br /><br />
						<el-link type="default" style="font-size:x-large" @click='todrugquery()' disabled>药品目录模块 </el-link><br />
					</div>
				</el-aside>
				<el-container>
					<el-main>
						<el-form class="my-query" style="width: 100%; align-items: center;">
							<div class="my-input" style="display: flex; margin: auto;">
								<div>
									<h2>
										药品目录管理
									</h2>
								</div>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<el-form-item label="药品名称" style="width: 550px;">
									<el-input type="text" v-model="drugs.DrugsName"></el-input>
								</el-form-item>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<el-form-item>
									<el-button type="primary" class="btn-center" @click='doSelectAll()'>查询</el-button>
								</el-form-item>&nbsp;&nbsp;
								<el-form-item>
									<el-button type="primary" class="btn-center" @click='toAdd()'>新增</el-button>
								</el-form-item>
							</div>
							<br />
							<el-table :data="tableData" stripe border class="el-table" height="400" style="width: 96%; margin: auto; align-items: center;">

								<el-table-column prop="id" label="ID" fixed="left" width="120" sortable></el-table-column>
								<el-table-column prop="drugsCode" label="药品编码" width="120" sortable></el-table-column>
								<el-table-column prop="drugsFormat" label="药品规格" width="100"></el-table-column>
								<el-table-column prop="drugsUnit" label="包装单位" width="100"></el-table-column>
								<el-table-column prop="drugsDosageID" label="药品剂型" width="100"></el-table-column>
								<el-table-column prop="manufacturer" label="生产厂家" width="100"></el-table-column>
								<el-table-column prop="drugsName" label="药品名称" width="120" sortable></el-table-column>
								<el-table-column prop="drugsTypeID" label="药品类型" width="100"></el-table-column>
								<el-table-column prop="mnemonicCode" label="拼音助记码" width="100"></el-table-column>
								<el-table-column prop="delMark" label="删除标记" width="100"></el-table-column>
								<el-table-column prop="drugsPrice" label="药品单价" width="100"></el-table-column>
								<el-table-column prop="dreationDate" label="创建时间" width="150"></el-table-column>


								<!-- fixed 用来锁定列 -->
								<el-table-column fixed="right" label="操作" width="300">
									<template #default="scope">
										<el-button type="info" @click='toUpdate(scope.row)'>修改</el-button>
										<el-button type="danger" @click='doDelete(scope.row, scope.$index)'>删除</el-button>
									</template>
								</el-table-column>
							</el-table>
						</el-form>
					</el-main>

				</el-container>
			</el-container>
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
	const drugs = ref({

		DrugsName: ''
	});
	const tableData = ref([]);





	// 五个模块路由跳转
	const toregister = () => {
		router.push('')
	}
	const todoc = () => {
		router.push('')
	}
	const totech = () => {
		router.push('')
	}
	const todrug = () => {
		router.push('/drugquery')
	}
	const tofinance = () => {
		router.push('')
	}
	const toback = () => {
		router.push('/back')
	}

	//三个子模块跳转 自己写
	const tooutpatientdispensing = () => {
		router.push('/outpatientdispensing')
	}
	const tooutpatientwithdrawal = () => {
		router.push('/outpatientwithdrawal')
	}
	const todrugquery = () => {
		router.push('/drugquery')
	}

	// 查询方法，名字可以改
	const doSelectAll = () => {
		let url = '/outpatientPharmacyWorkstation/drugCatalogueManagement/selectAll';
		axios.post(url, qs.stringify(drugs.value))
			.then(resp => {
				let data = resp.data.data;
				console.log('data=', data);
				tableData.value = data;
			})
			.catch((err) => {
				console.log('err=', err)
			});
	}

	const toUpdate = (u) => {
		router.push({
			path: '/drugupdate',
			query: {
				u: JSON.stringify(u) //把对象转为字符串
			}
		})
	}
	const toAdd = () => {
		router.push('/drugadd')
	}

	const open = () => {
		ElMessage('已删除！')
	}


	const doDelete = (u, i) => {
		if (!confirm('确认删除？')) {
			return false;
		}
		let url = '/outpatientPharmacyWorkstation/drugCatalogueManagement/delete';
		axios.post(url, qs.stringify(u))
			.then(resp => {
				let data = resp.data;
				console.log("i=", i);
				console.log('data=', data);
				doSelectAll(); //再执行个查询，删除前端数据不会写
				open();
			})
			.catch((err) => {
				console.log('err=', err)
			});
	}
</script>

<style scoped="scoped">
	.common-layout {
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
		background-image: url(../assets/main.jpg);
		background-size: 100%;
	}

	aside {
		width: 150px;
		background-color: #ECF5FF;
	}

	footer {
		width: 100%;
		height: 100px;
	}
</style>
