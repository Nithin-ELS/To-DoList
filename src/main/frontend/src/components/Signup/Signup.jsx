import { React } from "react";
import { Space, Card, Button, Form, Input} from "antd";
import './Signup.css';
import axios from "axios";
import { BASE_URL } from "../../common/Constants";

const Signup = () => {
    const [form] = Form.useForm();
    const apiURL = 'api/user/createUser';
    const onFinish = (values) =>{

    const {firstName, lastName, email, password} = values;
    console.log(password);
    // password = hashPassword(password);

    const userObject = {
            firstName,
            lastName,
            email,
            password,
          };
    
    axios.post(BASE_URL+apiURL,userObject)
    .then((response)=>{
        if (response.status === 200 )
            {
                alert("Success")
                form.resetFields();
            }
        })
        .catch((error)=>{
            console.log("Signup error : " + error);
            alert("Registration Failed")
        });
    }

    return (<>
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
                              whitespace:true,
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
                                type: 'email',
                                message: 'The input is not valid E-mail!',
                              },
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
                        <Input.Password/>
                    </Form.Item>
                    <Form.Item
                        label="Confirm Password"
                        name="confirmPassword"
                        rules={[
                            {
                              required: true,
                              message: 'Please confirm your password!',
                            },
                            ({ getFieldValue }) => ({
                              validator(_, value) {
                                if (!value || getFieldValue('password') === value) {
                                  return Promise.resolve();
                                }
                                return Promise.reject(new Error('The new password that you entered do not match!'));
                              },
                            }),
                          ]}                          
                    >
                        <Input.Password/>
                    </Form.Item>
                    <Button type="primary" htmlType="Submit" size="large">Signup</Button>
                </Form>

            </Card>

        </Space>
        </>);
}

export default Signup;