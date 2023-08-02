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
						<el-link type="default" style="font-size:x-large" @click='tooutpatientwithdrawal()' disabled>退药 </el-link><br /><br />
						<el-link type="default" style="font-size:x-large" @click='todrugquery()'>药品目录模块 </el-link><br />
					</div>
				</el-aside>

				<el-container>
					<el-main>
						<el-form class="my-query" style="width: 100%; align-items: center;">
							<div class="my-input" style="display: flex; margin: auto;">
								<div>
									<h2>退药</h2>
								</div>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<el-form-item label="病历号" style="width: 550px;">
									<el-input type="text" v-model="Prescription.caseNumber"></el-input>
								</el-form-item>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<el-form-item label="状态" style="width: 200px;">
									<el-select-v2 v-model="Prescription.State" :options="options" placeholder="单选" />
								</el-form-item>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<el-form-item>
									<el-button type="primary" class="btn-center" @click='doSelectAll()'>查询</el-button>
									<el-button type="danger" class="btn-center" @click='doUpdateAll(Prescription.caseNumber)'>退药完成</el-button>
								</el-form-item>&nbsp;&nbsp;
							</div>
							<br />
							<el-table :data="tableData" stripe border class="el-table" height="400" style="width: 96%; margin: auto; align-items: center;">
								<el-table-column prop="id" label="处方明细ID" fixed="left" width="120" sortable></el-table-column>
								<el-table-column prop="drugsName" label="药品名称" width="150"></el-table-column>
								<el-table-column prop="drugsFormat" label="药品规格" width="100" sortable></el-table-column>
								<el-table-column prop="amount" label="药品数量" width="200"></el-table-column>
								<el-table-column prop="drugsUnit" label="包装单位" width="100"></el-table-column>
								<el-table-column prop="drugsPrice" label="药品单价" width="100"></el-table-column>
								<el-table-column prop="sum" label="总价" width="100"></el-table-column>
								<el-table-column prop="manufacturer" label="生产厂家" width="120" sortable></el-table-column>
								<el-table-column prop="drugsUsage" label="用法" width="100"></el-table-column>
								<el-table-column prop="dosage" label="用量" width="100"></el-table-column>
								<el-table-column prop="state" label="状态" width="100"></el-table-column>
								<el-table-column prop="realName" label="患者姓名" width="100"></el-table-column>
								<el-table-column prop="gender" label="性别" width="50"> </el-table-column>
								<el-table-column prop="age" label="年龄" width="50"></el-table-column>
								<el-table-column prop="caseNumber" label="病历号" width="100"></el-table-column>

								<!-- fixed 用来锁定列 -->
								<el-table-column fixed="right" label="操作" width="300">
									<template #default="scope">
										<el-input type="text" v-model="PrescriptionDetailed[scope.$index]" style="width: 50%;" placeholder="请输入退药数量"></el-input>&nbsp;&nbsp;
										<el-button type="danger" @click='doUpdate(scope.row,scope.$index)'>确认退药</el-button>
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
		ElNotification
	} from 'element-plus'

	const router = useRouter();

	const Prescription = ref({

		caseNumber: '',
		State: ''
	});

	const PrescriptionDetailed = ref([]);

	const tableData = ref([]);

	const initials = ['已交费', '已发药', '已退药', '已退费']

	const num = ref(1);

	// 单选
	const options =
		Array.from({
			length: 4
		}).map((_, idx) => ({
			value: `${idx + 3}`,
			label: `${initials[idx]}`,
		}))

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
		let url = '/outpatientPharmacyWorkstation/outpatientWithdrawal/selectAll';
		axios.post(url, qs.stringify(Prescription.value))
			.then(resp => {
				let data = resp.data.data;
				console.log('data=', data);
				tableData.value = data;
				console.log('tabledata=', tableData);
			})
			.catch((err) => {
				console.log('err=', err)
			});
	}

	const success = () => {
		ElNotification({
			title: 'Success',
			message: '退药成功！',
			type: 'success',
		})
	}

	const doUpdate = (u, i) => {
		let url = '/outpatientPharmacyWorkstation/outpatientWithdrawal/update';
		u.amount = PrescriptionDetailed.value[i]
		console.log('--u=', u);
		axios.post(url, qs.stringify(u))
			.then(resp => {
				let data = resp.data;
				console.log('data=', data);
				doSelectAll(); //再执行个查询，删除前端数据不会写
				success();
			})
			.catch((err) => {
				console.log('err=', err)
			});
	}

	const doUpdateAll = (u) => {
		let url = '/outpatientPharmacyWorkstation/outpatientWithdrawal/updateAll';
		console.log('caseNumber=', u);
		axios.post(url, 'caseNumber=' + u)
			.then(resp => {
				let data = resp.data;

				doSelectAll(); //再执行个查询，删除前端数据不会写
				success();
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
