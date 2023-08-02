<template>
	<div class="common-layout">
		<el-container>
			<el-header style="border-bottom: 1px solid #bebebe;">

				<div class="my-top" style="float: right; vertical-align: bottom; margin-right: 10px;"><br />
					<el-link type="info" style=" color: #F2F3F5;" @click='toDiagnosisCompleted()'>病历首页 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='toInspectionApplication()'>检查申请 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='toOutpatientDiagnosis()'>门诊确诊 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style="  color: #F2F3F5;" @click='toPatentPrescription()'>成药处方 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='toDiagnosisCompleted()'>诊毕 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='toPersonalWorkloadStatistics()'>个人工作量统计 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="danger" style=" color: #F2F3F5;" @click='back()'>退出登录</el-link>&nbsp;
				</div>
			</el-header>
			<el-container>
				<el-aside style="border-right: 1px solid #aaaaaa;">
					<div class="bg"></div>
					<br />
					<div class="content">
						<el-form-item label="患者姓名" style="width: 260px;">
							<el-input type="text" v-model="searchRegister.realName" placeholder="请输入患者姓名"></el-input>
						</el-form-item>
						<el-form-item label="病历单号" style="width: 260px;">
							<el-input type="text" v-model="searchRegister.caseNumber" placeholder="请输入患者病历单号"></el-input>
						</el-form-item>
						<el-form-item>
							<el-button type="primary" class="btn-center" @click='doselect()'>查询</el-button>
						</el-form-item>
						<el-table :data="listAside" stripe border class="el-table" style="width: 96%;height: 190px; margin: auto; align-items: center;">
							<el-table-column prop="caseNumber" label="病历号" sortable width="100"></el-table-column>
							<el-table-column prop="realName" label="姓名" sortable width="100"></el-table-column>
							<el-table-column fixed="right" label="操作" width="90">
								<template #default="scope">
									<el-button type="primary" @click='getprescription(scope.$index)'>查看</el-button>
								</template>
							</el-table-column>
						</el-table><br>

						<el-button type="primary" @click='showtemp()'>显示组套</el-button><br><br>

						<el-table :data="tempList" stripe border class="el-table" style="width: 300px;height: 190px; margin: auto; align-items: center;">
							<el-table-column prop="name" label="组套名" sortable width="120px"></el-table-column>
							<el-table-column prop="userID" label="创建者ID" sortable width="120px"></el-table-column>
							<el-table-column prop="scope" label="适用范围" sortable width="120px"></el-table-column>
							<el-table-column fixed="right" label="操作" width="120px">
								<template #default="scope">
									<el-button type="primary" @click='usetemp(scope.$index)' style="size:mini; height: 30px; width: 40px;">使用</el-button>
									<el-button type="danger" @click='deletetemp(scope.$index)' style="size:mini; height: 30px; width: 40px;">删除</el-button>
								</template>
							</el-table-column>
						</el-table>
					</div>
				</el-aside>
				<el-container>
					<el-main>
						<el-row>
							<el-col :span="16">
								<el-row style="display: flex;">
									<el-form style="width: 70%;margin-left: 5%;">
										<el-form-item label="药品名称" style="margin-right: 30px; width: 100%;">
											<el-input v-model="curPrescription.drugsName" placeholder="请输入药品名称"></el-input>
										</el-form-item>
									</el-form>&nbsp;&nbsp;&nbsp;&nbsp;
									<el-button type="primary" @click='adddrugs()'>增药</el-button>
									<br /><br>
								</el-row>

								<el-table :data="detailsList" stripe border class="el-table" style="width: 90%;height: 480px; margin: auto; align-items: center;">
									<el-table-column prop="drugsName" label="药品名称" sortable width="120">
										<template #default="scope">
											<el-input v-model="scope.row.drugsName" disabled="true"></el-input>
										</template>
									</el-table-column>
									<el-table-column prop="drugsUsage" label="用法" sortable width="120">
										<template #default="scope">
											<el-input v-model="scope.row.drugsUsage"></el-input>
										</template>
									</el-table-column>
									<el-table-column prop="dosage" label="用量" sortable width="120">
										<template #default="scope">
											<el-input v-model="scope.row.dosage"></el-input>
										</template>
									</el-table-column>
									<el-table-column prop="frequency" label="频次" sortable width="120">
										<template #default="scope">
											<el-input v-model="scope.row.frequency"></el-input>
										</template>
									</el-table-column>
									<el-table-column prop="amount" label="数量" sortable width="120">
										<template #default="scope">
											<el-input v-model="scope.row.amount"></el-input>
										</template>
									</el-table-column>
									<el-table-column fixed="right" label="操作" width="100">
										<template #default="scope">
											<el-button type="danger" @click='deletedrug(scope.$index)' style="size:mini; height: 30px; width: 28px;">删药</el-button>
											<el-button type="primary" @click='savedrug(scope.$index)' style="size:mini; height: 30px; width: 28px;">保存</el-button><br><br>
										</template>
									</el-table-column>
								</el-table><br /><br />

								<el-row style="display: flex;">
									<el-form style="width: 40%;margin-left: 6%;">
										<el-form-item label="组套名称" style="margin-right: 30px; width: 100%;">
											<el-input v-model="newTemp.Name" placeholder="请输入组套名称"></el-input>
										</el-form-item>
									</el-form>&nbsp;&nbsp;&nbsp;&nbsp;
									<el-form-item label="权限等级">
										<el-input-number v-model="newTemp.Scope" :min="1" :max="3" />
									</el-form-item>&nbsp;&nbsp;&nbsp;&nbsp;
									<el-button type="primary" @click='saveastemp()'>存为组套</el-button>
								</el-row>

							</el-col>
							<el-col :span="8">
								<div>
									<div style="display: flex;">
										<el-input type="text" v-model="newPrescription.PrescriptionName" placeholder="请输入处方名" style="width: 80%;"></el-input>
										<el-button type="primary" @click='addprescription()' style="margin-left: 5%;">增方</el-button>
										<el-button type="primary" @click='doupdate()'>刷新</el-button>
									</div><br />
									<el-table :data="prescriptionList" stripe border class="el-table" style="width: 100%;height: 550px; margin: auto; align-items: center;">
										<el-table-column prop="prescriptionName" label="处方名称" sortable width="100"></el-table-column>
										<el-table-column prop="prescriptionState" label="状态" sortable width="50"></el-table-column>
										<el-table-column fixed="right" label="操作" width="235">
											<template #default="scope">
												<el-button type="primary" @click='staging(scope.$index)' style="size:mini; height: 30px; width: 28px;">暂存</el-button>
												<el-button type="primary" @click='open(scope.$index)' style="size:mini; height: 30px; width: 28px;">开立</el-button>
												<el-button type="primary" @click='edit(scope.$index)' style="size:mini; height: 30px; width: 28px;">编辑</el-button>
												<el-button type="primary" @click='repeal(scope.$index)' style="size:mini; height: 30px; width: 28px;">作废</el-button>
												<el-button type="danger" @click='dodelete(scope.$index)' style="size:mini; height: 30px; width: 28px;">删除</el-button>
											</template>
										</el-table-column>
									</el-table>
								</div>
							</el-col>
						</el-row>
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
		inject,
		watch
	} from 'vue';
	const router = useRouter();

	const searchRegister = ref({
		DeptID: '1',
		UserID: '1',
	});

	const listAside = ref([]);
	const prescriptionList = ref([]);
	const detailsList = ref([{
		id: '',
		iD: '',
		drugsName: '',
		drugsUsage: '',
		dosage: '',
		frequency: '',
		amount: '',
		prescriptionID: ''
	}]);
	const prescriptionID = ref('');
	const newPrescription = ref({
		PrescriptionName: '',
		MedicalID: '',
		RegistID: 1
	});
	const curPrescription = ref({
		prescriptionID: '',
		drugsName: '',
		drugsUsage: '',
		dosage: '',
		frequency: '',
		amount: ''
	});
	const tempList = ref([]);
	const tempDetailsList = ref([]);
	const newTemp = ref({
		Name: '',
		Scope: '',
		ID: ''
	});

	// 六个模块路由跳转
	const toDiagnosisCompleted = () => {
		router.push({
			path: '/DiagnosisCompleted',
		});
	}
	const toPersonalWorkloadStatistics = () => {
		router.push({
			path: '/PersonalWorkloadStatistics',
		})
	}
	const toOutpatientDiagnosis = () => {
		router.push({
			path: '/OutpatientDiagnosis',
		})
	}
	const toInspectionApplication = () => {
		router.push({
			path: '/InspectionApplication',
		})
	}
	const toPatentPrescription = () => {
		router.push({
			path: '/PatentPrescription',
		})
	}
	const back = () =>{
		router.push({
			path:'/index',
		})
	}
	// const tofinance = () => {
	// 	router.push('')
	// }


	const doselect = () => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/select';
		axios.post(url, qs.stringify(searchRegister.value))
			.then((resp) => {
				let data = resp.data.data;
				listAside.value = data;
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}

	const showtemp = () => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/showtemp';
		axios.post(url)
			.then((resp) => {
				let data = resp.data.data;
				tempList.value = data;
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}

	const deletetemp = (i) => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/deletetemp';
		axios.post(url, 'ID=' + tempList.value[i].id)
			.then((resp) => {
				let data = resp.data.data;
				if (data == 0) {
					alert('没有删除权限');
				} else {
					tempList.value.splice(i, 1);
				}
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}

	const usetemp = (i) => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/usetemp';
		axios.post(url, 'ID=' + tempList.value[i].id)
			.then((resp) => {
				let data = resp.data.data;
				let dataLength = data.length;
				let detailsLength = detailsList.value.length;

				for (let i = 0; i < dataLength; i++) {
					detailsList.value.push({
						id: '',
						iD: '',
						drugsName: '',
						drugsUsage: '',
						dosage: '',
						frequency: '',
						amount: '',
						prescriptionID: curPrescription.value.prescriptionID
					})
				}
				for (let i = 0; i < dataLength; i++) {
					detailsList.value[i + detailsLength].dosage = data[i].dosage;
					detailsList.value[i + detailsLength].drugsName = data[i].drugsName;
					detailsList.value[i + detailsLength].drugsUsage = data[i].drugsUsage;
					detailsList.value[i + detailsLength].frequency = data[i].frequency;
				}
				console.log(detailsList.value);
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});

	}

	const saveastemp = () => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/saveastemp';
		newTemp.value.ID = curPrescription.value.prescriptionID;
		axios.post(url, qs.stringify(newTemp.value))
			.then((resp) => {
				let data = resp.data.data;
				if (data == 0) {
					alert('已经存在同名同人同权限的组套了');
				} else {
					alert('成功存为组套');
					url = '/outpatientDoctorWorkStation/patentPrescription/showtemp';
					axios.post(url)
						.then((resp) => {
							let data = resp.data.data;
							tempList.value = data;
						})
						.catch(
							(err) => {
								console.log('err=', err);
							});
				}
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}
	const getprescription = (i) => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/getprescription';
		newPrescription.value.RegistID = listAside.value[i].id;
		axios.post(url, 'ID=' + listAside.value[i].id)
			.then((resp) => {
				let data = resp.data.data;
				prescriptionList.value = data;
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}

	const addprescription = () => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/addprescription';
		axios.post(url, qs.stringify(newPrescription.value))
			.then((resp) => {})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}

	const doupdate = () => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/getprescription';
		axios.post(url, 'ID=' + newPrescription.value.RegistID)
			.then((resp) => {
				let data = resp.data.data;
				prescriptionList.value = data;
				console.log(data);
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}

	const edit = (i) => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/editprescription';
		curPrescription.value.prescriptionID = prescriptionList.value[i].id;
		axios.post(url, 'preID=' + prescriptionList.value[i].id)
			.then((resp) => {
				let data = resp.data.data;
				detailsList.value = data;
				console.log(detailsList.value);
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}

	const staging = (i) => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/staging';
		axios.post(url, "preID=" + prescriptionList.value[i].id)
			.then((resp) => {
				let data = resp.data.data;
				if (data == 0) {
					alert('状态不符合');
				} else {
					prescriptionList.value[i].prescriptionState = '1';
				}
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}

	const open = (i) => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/open';
		axios.post(url, "preID=" + prescriptionList.value[i].id)
			.then((resp) => {
				let data = resp.data.data;
				if (data == 0) {
					alert('状态不符合');
				} else {
					prescriptionList.value[i].prescriptionState = '2';
				}
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});

	}

	const repeal = (i) => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/repeal';
		axios.post(url, "preID=" + prescriptionList.value[i].id)
			.then((resp) => {
				let data = resp.data.data;
				if (data == 0) {
					alert('状态不符合');
				} else {
					prescriptionList.value[i].prescriptionState = '0';
				}
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});

	}

	const dodelete = (i) => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/dodelete';
		axios.post(url, "preID=" + prescriptionList.value[i].id)
			.then((resp) => {
				let data = resp.data.data;
				if (data == 0) {
					alert('状态不符合');
				} else {
					prescriptionList.value.splice(i, 1);
				}
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});

	}

	const adddrugs = () => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/adddrugs';
		console.log(curPrescription.value);
		axios.post(url, 'drugsName=' + curPrescription.value.drugsName)
			.then((resp) => {
				let data = resp.data.data;
				if (data == 0) {
					alert("没有该药品");
				} else {
					alert("增药成功");
					let temp = {
						id: '',
						prescriptionID: curPrescription.value.prescriptionID,
						drugsName: curPrescription.value.drugsName,
						drugsUsage: '',
						dosage: '',
						frequency: '',
						amount: ''
					}
					detailsList.value.push(temp);
					console.log(detailsList.value);
				}
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});

	}

	const deletedrug = (i) => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/deletedrug';
		axios.post(url, 'ID=' + detailsList.value[i].id)
			.then((resp) => {
				detailsList.value.splice(i, 1);
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}

	const savedrug = (i) => {
		let url = '';
		url = '/outpatientDoctorWorkStation/patentPrescription/savedrug';
		detailsList.value[i].iD = detailsList.value[i].id;
		axios.post(url, qs.stringify(detailsList.value[i]))
			.then((resp) => {})
			.catch(
				(err) => {
					console.log('err=', err);
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
		height: 60px;
		width: 100%;
		background-image: url(../assets/logo.jpg);
		background-size: 100% 100%;
	}

	main {
		width: 100%;
		background-image: url(../assets/main.jpg);
		background-size: 120% 100%;
	}

	aside {
		width: 350px;
		position: relative;

	}

	.bg {
		background-image: url(../assets/aside.jpg);
		height: 100%;
		width: 100%;
		float: left;
		background-size: cover;
		filter: blur(8px);
	}


	.content {
		margin-left: 13%;
		position: absolute;
	}
</style>
