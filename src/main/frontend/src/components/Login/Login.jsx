import { Form, Input, Button, Space, Card} from "antd";
import FormItem from "antd/es/form/FormItem";
import { UserOutlined, LockOutlined } from '@ant-design/icons';


function Login (){



    return (
        <Space style={{marginTop: 300}}>

        <Card style={{ backgroundColor: '#d9d9d9'}}>
        <Form 
        name="login_form"
        className="login-form"
        >

        <h1 style={{ color: '#2f54eb'}}>Login</h1>
        
        <Form.Item name="email" rules={[{ required: true, message: 'Please input your Email!' }]} >
                <Input prefix={<UserOutlined />} placeholder="Email"/>
                </Form.Item>
                
                <Form.Item name="password"  rules={[{ required: true, message: 'Please input your Password!' }]}>
                <Input prefix={<LockOutlined />} type="password" placeholder="Password"/>
                </Form.Item>
                
                <FormItem style={{marginRight: 7}}>
                <Space>
                <Button type="primary" htmlType="submit">Login</Button>
                
                <Button type="primary">Signup</Button>
                </Space>
                </FormItem>

                <b><a>Forgot Password?</a></b>
                
                </Form>
                </Card>
        </Space>
                );
            }

export default Login;