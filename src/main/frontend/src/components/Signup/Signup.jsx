import { React } from "react";
import { Space, Card, Button, Form, Input} from "antd";
import './Signup.css';
const Signup = () => {
    const [form] = Form.useForm();

    const onFinish = (values) =>{
        console.log(values);
    }

    return (
        <Space className="signup-container">
            <Card
                style={{
                    marginTop:"50%",
                    width: 500,
                }}
                bordered={true}
            >
                <h1>SIGNUP</h1>
                <Form 
                    form={form}
                    onFinish={onFinish}
                    labelCol={{ span: 8 }}
                    wrapperCol={{ span: 16 }}
                >
                    <Form.Item
                        label="First Name"
                        name="firstName"
                        rules={[
                            {
                              required: true,
                              message: 'Please input your Firstname!',
                            },
                          ]}
                    >
                        <Input/>
                    </Form.Item>
                    <Form.Item
                        label="Last Name"
                        name="lastName"
                        rules={[
                            {
                              required: true,
                              message: 'Please input your Lastname!',
                            },
                          ]}
                          >
                        <Input/>
                        </Form.Item>
                    <Form.Item
                        label="Email"
                        name="email"
                        rules={[
                            {
                              required: true,
                              message: 'Please input your Email address!',
                            },
                          ]}
                    >
                        <Input/>
                    </Form.Item>
                    <Form.Item
                        label="Password"
                        name="password"
                        rules={[
                            {
                              required: true,
                              message: 'Please input new password!',
                            },
                          ]}
                    >
                        <Input/>
                    </Form.Item>
                    <Form.Item
                        label="Confirm Password"
                        name="confirmPassword"
                        rules={[
                            {
                              required: true,
                              message: 'Please input confirm password!',
                            },
                          ]}
                    >
                        <Input/>
                    </Form.Item>
                    <Button type="primary" htmlType="Submit" size="large">Signup</Button>
                </Form>

            </Card>

        </Space>);
}

export default Signup;