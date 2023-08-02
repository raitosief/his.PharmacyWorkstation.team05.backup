<template>
	<div class="common-layout">
		<el-container>
			<el-header style="border-bottom: 1px solid #bebebe;">
				<!-- <h1 style="float: left;font-size: xx-large;">查询模板</h1> -->
				<div class="my-top" style="float: right; vertical-align: bottom; margin-right: 10px;">
					<br />
					<el-link type="info" style=" color: #F2F3F5;" @click='toregister()'>挂号 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='todoc()'>门诊 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='totech()'>医技 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style="  color: #F2F3F5;" @click='todrug()'>药房 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='tofinance()'>财务 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="danger" style=" color: #F2F3F5;" @click='toback()'>退出 </el-link>&nbsp;
				</div>
			</el-header>
			<el-container>
				<el-aside style="border-right: 1px solid #aaaaaa;">
					<div>
						<br /><br /><br />
						<el-link type="default" style="font-size:x-large" @click='tooutpatientdispensing()'>发药 </el-link><br /><br />
						<el-link type="default" style="font-size:x-large" @click='tooutpatientwithdrawal()'>退药 </el-link><br /><br />
						<el-link type="default" style="font-size:x-large" @click='todrugquery()'>药品目录模块 </el-link><br />
					</div>
				</el-aside>
				<el-container class="down">
					<el-main style="align-items: center;">
						<el-form class="my-add" style="width: 100%; ">


							<el-date-picker v-model="drugs.creationDate" type="datetime" placeholder="Select date and time" :shortcuts="shortcuts" />
							<br /><br />
							<el-form-item label="药品编码" style="width: 65%;">
								<el-input type="text" v-model="drugs.drugsCode"></el-input>
							</el-form-item>
							<el-form-item label="药品剂型" style="width: 65%;">
								<el-input type="text" v-model="drugs.drugsDosageID"></el-input>
							</el-form-item>
							<el-form-item label="药品规格" style="width: 65%;">
								<el-input type="text" v-model="drugs.drugsFormat"></el-input>
							</el-form-item>
							<el-form-item label="药品名称" style="width: 65%;">
								<el-input type="text" v-model="drugs.drugsName"></el-input>
							</el-form-item>
							<el-form-item label="药品价格" style="width: 65%;">
								<el-input type="text" v-model="drugs.drugsPrice"></el-input>
							</el-form-item>
							<el-form-item label="包装单位" style="width: 65%;">
								<el-input type="text" v-model="drugs.drugsUnit"></el-input>
							</el-form-item>
							<el-form-item label="生产厂家" style="width: 65%;">
								<el-input type="text" v-model="drugs.manufacturer"></el-input>
							</el-form-item>
							<el-form-item label="助记码" style="width: 65%;">
								<el-input type="text" v-model="drugs.mnemonicCode"></el-input>
							</el-form-item>



							<el-form-item>
								<el-button type="primary" class="btn-center" @click='doAdd()' color="#1F4FA3">新增</el-button>
							</el-form-item>



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
		useRouter,
		useRoute
	} from 'vue-router'
	import {
		ref
	} from 'vue'
	const router = useRouter();
	const route = useRoute();



	const drugs = ref({
		creationDate: '',
		drugsCode: '',
		drugsDosageID: '',
		drugsFormat: '',
		drugsName: '',
		drugsPrice: '',
		drugsUnit: '',
		manufacturer: '',
		mnemonicCode: ''
	});













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
	const doAdd = () => {
		let url = '/outpatientPharmacyWorkstation/drugCatalogueManagement/add';
		axios.post(url, qs.stringify(drugs.value))
			.then(resp => {
				let data = resp.data.data;
				console.log('data=', data);

			})
			.catch((err) => {
				console.log('err=', err)
			});
			todrugquery();
	}
	const state2 = () => {

	}
	const state3 = () => {

	}

	// 日期时间选择器


	const defaultTime = new Date(2000, 1, 1, 12, 0, 0)

	const shortcuts = [{
			text: 'Today',
			value: new Date(),
		},

	]
</script>

<style scoped="scoped">
	.common-layout {
		width: 100%;
		height: 100%;
		display: flex;
		flex-direction: column;
	}

	header {
		height: 60px;
		width: 100%;
		background-image: url(../assets/logo.jpg);
		background-size: 100% 100%;
	}

	main {
		width: 100%;
		display: flex;
		background-image: url(../assets/doc.jpg);
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

	.my-add {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}


	.demonstration {
		display: block;
		color: var(--el-text-color-secondary);
		font-size: 14px;
		margin-bottom: 20px;
	}

	.example-showcase .el-select-v2 {
		margin-right: 20px;
	}
</style>
