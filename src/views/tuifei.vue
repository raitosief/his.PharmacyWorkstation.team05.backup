<template>
	<div class="common-layout">
		<el-container>
			<el-header style="border-bottom: 1px solid #bebebe;">
				
				<div class="my-top" style="float: right; vertical-align: bottom; margin-right: 10px;"><br />
					<el-link type="info" style=" color: #F2F3F5;" @click='toregister()'>挂号 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='todoc()'>门诊 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='totech()'>医技 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style="  color: #F2F3F5;" @click='todrug()'>药房 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='tofinance()'>财务 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="danger" style=" color: #F2F3F5;">退出 </el-link>&nbsp;
				</div>
			</el-header>
			<el-container>
				<el-aside style="border-right: 1px solid #aaaaaa;">
					<div class="bg"></div>
					<br /><br /><br />
					<div class="content">
						<el-link type="success" el-button @click="Reg()" style="font-size:x-large">挂号 </el-link><br /><br />
						<el-link type="success" el-button @click="Charge()" style="font-size:x-large">收费 </el-link><br /><br />
						<el-link type="success" el-button @click="Back()" style="font-size:x-large">退号 </el-link><br />
					</div>
				</el-aside>
				<el-container>
					<el-main>
						
						<el-form-item label="发票号">
							<el-input type="text" v-model="Invoice.invoiceNum"></el-input>
						</el-form-item>
						
						<el-form-item label="挂号ID">
							<el-input type="text" v-model="Invoice.registID"></el-input>
						</el-form-item>
							
								
								&nbsp;&nbsp;&nbsp;&nbsp;
								
								&nbsp;&nbsp;&nbsp;&nbsp;
								<el-form-item >
									<el-button type="primary" class="btn-center" @click='doSelectAll()'>
										查询</el-button>
								</el-form-item>
							<br />
							
					
					</el-main>
					<el-footer style="border-top: 1px solid #bebebe;"></el-footer>
				</el-container>
			</el-container>
		</el-container>
	</div>
	<el-dialog
	    title="发票信息"
	    :visible.sync="dialogBackNum"
	    width="45%"
	    center>
	  <el-form
	      ref="invoiceInFormation"
	      :model="invoiceInFormation"
	      label-width="150px">
	    <el-form-item label="发票编号:">
	      <el-card class="box-card" v-text="invoiceInFormation.invoiceNum">
	      </el-card>
	    </el-form-item>
	    <el-form-item label="发票金额:">
	      <el-card class="box-card" v-text="invoiceInFormation.money">
	      </el-card>
	    </el-form-item>
	    <el-form-item label="发票状态:">
	      <el-card class="box-card" v-text="invoiceInFormation.state">
	      </el-card>
	    </el-form-item>
	    <el-form-item label="收/退费时间:">
	      <el-card class="box-card" v-text="invoiceInFormation.creationTime">
	      </el-card>
	    </el-form-item>
	    <el-form-item label="收/退费人员ID:">
	      <el-card class="box-card" v-text="invoiceInFormation.userID">
	      </el-card>
	    </el-form-item>
	    <el-form-item label="挂号ID:">
	      <el-card class="box-card" v-text="invoiceInFormation.registID">
	      </el-card>
	    </el-form-item>
	    <el-form-item label="收费方式:">
	      <el-card class="box-card" v-text="invoiceInFormation.feeType">
	      </el-card>
	    </el-form-item>
	    <el-form-item label="冲红发票号码:">
	      <el-card class="box-card" v-text="invoiceInFormation.back">
	      </el-card>
	    </el-form-item>
	    <el-form-item label="发票状态:">
	      <el-card class="box-card" v-text="invoiceInFormation.dailyState">
	      </el-card>
	    </el-form-item>
	  </el-form>
	  <span slot="footer" class="dialog-footer">
	    <el-button @click="dialogBackNum = false">取 消</el-button>
	    <el-button type="primary" @click="dialogBackNum = false">确 定</el-button>
	</span>
	</el-dialog>
	
	<div class="text">
		收信息列表
				<el-table :data="list" stripe border class="el-table" style="width: 96%;margin:0 auto;" height="500px" >
					<el-table-column prop="id" label="id" sortable></el-table-column>
					<el-table-column prop="registID" label="挂号ID" sortable></el-table-column>
					<el-table-column prop="invoiceNum" label="发票号" sortable></el-table-column>
					<el-table-column prop="money" label="费用" sortable></el-table-column>
					<el-table-column prop="state" label="状态" sortable></el-table-column>
					
					<el-table-column label="操作">
						<template #default="scope">
							
							<el-button type="danger" @click='doBack(scope.row)'>退号</el-button>
						</template>
					</el-table-column>
				</el-table>
				
		<br />	
	</div>
</template>

<script setup>
	//引入公共的模块及变量--基本是固定代码
		import {
			ref,
			inject,
			onMounted
			
		} from 'vue'
		const axios = inject('axios');
		const qs = inject('qs');
	import{useRouter} from 'vue-router' 
	import { ElMessageBox, ElMessage } from 'element-plus'
	const router=useRouter();
	
	
		const user = ref({
			uname: '',
			pass:'',
			realname: ''
		});
		
		const Invoice =ref({
			state :'',
			id: '',
			creationTime:'',
			invoiceNum:'',
			money:'',
			back:'',
			feeType:'',
			registID:'',
			dailyState:'',
			userID:''
			
		})
		
		
		const msg = ref('');
		const list =ref('');
		
		const invoice = ref([]);
		const query_registID = ref('');
		// 其他属性也可以添加在此处
		
		// 异步获取数据并赋值给响应式变量
		
		
		// 异步获取数据并赋值给响应式变量
		onMounted(async () => {
		  // 模拟异步操作
		  await fetchData();
		
		  // 将获取的数据赋值给响应式变量
		  list.value = [];
		  invoice.value = [];
		  query_registID.value = '';
		});
		
		async function fetchData() {
		  // 模拟异步获取数据
		  return new Promise((resolve) => {
		    setTimeout(() => {
		      resolve();
		    }, 1000);
		  });
		}
		
		
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
		router.push('')
	}
	const tofinance = () => {
		router.push('')
	}
	
	//三个子模块跳转 自己写
	const Reg = () => {
		router.push('/Reg')
	}
	const Charge = () => {
		router.push('/Charge')
	}
	
	const Back = () => {
		router.push('/tuifei')
	}
		
		const doAdd = () => {
		
			let url = '/backnumber/addInvoice';
			axios.post(url, qs.stringify(Invoice.value))
				.then((resp) => {
					let data = resp.data;
					console.log('data=', data);
					//list.value=data;
					
					if (data != 0) {
						//提示增加成功
						msg.value = '发票增加成功'
		
					} else {
						msg.value = '增加失败，请联系管理员处理'
					}
		
				})
				.catch((err) => {
					console.log('err=', err);
				});
		}
		
		const doSelectAll = () => {
			let url = '/backnumber/selectAllInvoice';
			axios.post(url, qs.stringify(Invoice.value))
				.then((resp) => {
					let data = resp.data.data;
					console.log('data=', data);
					list.value = data;
		
				})
				.catch((err) => {
					console.log('err=', err);
				});
		}
		
		//修改
		const toUpdate=(u)=>{
			router.push({
				path:'/InvoiceUpdate',
				query:{
					u:JSON.stringify(u)
				}
			})
			
		}
	   // 删除发票
		const doDelete = (u,i) => {
			if(!confirm('您确定删除该记录吗')){
				return false;
			}
			let url = '/backnumber/deleteInvoice';
			axios.post(url, qs.stringify(u))
				.then((resp) => {
					let data = resp.data;
					
				  if(data>0){
				  	//提示
				  	msg.value='delete ok'
					//把当前的list对应等数据删除
					list.value.splice(i,1);
					//splice方法从参数i的索引开始删除一个元素
				  }else{
				  	msg.value='删除失败，请联系管理员处理'
				  }
				})
				.catch((err) => {
					console.log('err=', err);
				});
		}
		
		//退号
	//import { confirm, message, axios } from 'vue' // 假设您已经从Vue中引入了confirm、message和axios
	
	
	const invoiceInFormation = ref({  // 将invoiceInFormation变量改为响应式引用
	  id: '',
	  invoiceNum: '',
	  money: '',
	  userID: '',
	  state: '',
	  registID: '',
	  feeType: '',
	  dailyState: '',
	  createTime: '',
	  back: '',
	});
	
	const dialogBackNum = ref(false);
	
	const doBack = (data) => {
	  ElMessageBox.confirm('此操作将退回挂号, 是否继续?', '提示', {
	    confirmButtonText: '确定',
	    cancelButtonText: '取消',
	    type: 'warning'
	  })
	    .then(() => {
	      axios.post('/backnumber/backNumber', data)
	        .then((resp) => {
	          invoiceInFormation.value = resp.data.data;
	          console.log("我是msg", resp.data.msg);
	          if (resp.data.msg == '退号成功') {
	            dialogBackNum.value = true;
	          }
	        })
	        .catch((err) => {
	          console.log("err", err);
	        });
	      initData();
	    })
	    .catch(() => {
	      ElMessage({
	        type: 'info',
	        message: '已取消退号'
	      });
	    });
	};
	
	
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
		background-image: url(../assets/main.jpg);
		background-size: 100% ;
	}

	aside {
		width: 150px;
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
	.content{
			    margin-left: 20%;
			    position: absolute;
	}

	footer {
		width: 100%;
		height: 100px;
	}
</style>
