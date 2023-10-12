import axios from "axios";
import { Form, Input, Button, Space, Card } from "antd";
import FormItem from "antd/es/form/FormItem";
import { UserOutlined, LockOutlined } from "@ant-design/icons";
import instance from "../../common/AxiosInstance";
import { useState } from "react";

const apiURL = "/api/user/login?";

function Login() {
  // localStorage.clear();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleLogin = async (e) => {
    try {
      await instance
        .get(apiURL, {
          params: {
            email: email,
            pass: password,
          },
        })
        .then((response) => {
          if (response.status === 200) {
            // localStorage.setItem("email", JSON.stringify(response.data.email));
            alert("login successful");
          } else alert("Invalid creds");
        });
    } catch (error) {
      console.error("Network error:" + error);
    }
  };

  return (
    <Space style={{ marginTop: 300 }}>
      <Card style={{ backgroundColor: "#d9d9d9" }}>
        <Form name="login_form" className="login-form" onFinish={handleLogin}>
          <h1 style={{ color: "#2f54eb" }}>Login</h1>

          <Form.Item
            name="email"
            rules={[{ required: true, message: "Please input your Email!" }]}
          >
            <Input
              prefix={<UserOutlined />}
              placeholder="Email"
              onChange={handleEmailChange}
            />
          </Form.Item>

          <Form.Item
            name="password"
            rules={[{ required: true, message: "Please input your Password!" }]}
          >
            <Input
              prefix={<LockOutlined />}
              type="password"
              placeholder="Password"
              onChange={handlePasswordChange}
            />
          </Form.Item>

          <FormItem style={{ marginRight: 7 }}>
            <Space>
              <Button type="primary" htmlType="submit">
                Login
              </Button>

              <Button type="primary">Signup</Button>
            </Space>
          </FormItem>

          <b>
            <a>Forgot Password?</a>
          </b>
        </Form>
      </Card>
    </Space>
  );
}

export default Login;
