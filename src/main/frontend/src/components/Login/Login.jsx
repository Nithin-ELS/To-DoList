import axios from "axios";
import { Form, Input, Button, Space, Card } from "antd";
import FormItem from "antd/es/form/FormItem";
import { UserOutlined, LockOutlined } from "@ant-design/icons";
import { useState } from "react";
import { BASE_URL } from "../../common/Constants";


const apiURL = "/api/user/login?";

function Login() {
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
      await axios
        .get(BASE_URL +apiURL, {
          params: {
            email: email,
            pass: password,
          },
        })
        .then((response) => {
          if (response.status === 200) {
            alert("login successful");
          } else {
            alert("Invalid creds");
          }
        });
    } catch (error) {
      console.error("Network error:" + error);
    }
  };

  // const validatePassword = (rule, value) => {
  //   return new Promise((resolve, reject) => {
  //     if (value && value.length >= 8) {
  //       resolve();
  //     } else {
  //       reject("Password must be atleast 8 characters long");
  //     }
  //   });
  // };

  const validatePassword = (rule, value) => {
    return new Promise((resolve, reject) => {
      if (!value) {
        reject("Password is required");
      } else if (
        !/^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&*])\S{8,}$/.test(value)
      ) {
        reject(
          "Password must meet the requirements: 8 characters, at least 1 uppercase, 1 lowercase, 1 number, and 1 special character. No spaces allowed."
        );
      } else {
        resolve();
      }
    });
  };

  return (
    <Space style={{ marginTop: 150 }}>
      <Card style={{ backgroundColor: "#d9d9d9" }}>
        <Form name="login_form" className="login-form" onFinish={handleLogin}>
          <h1 style={{ color: "#2f54eb" }}>Login</h1>

          <Form.Item
            name="email"
            rules={[{ required: true, message: "Please input your Email!" }]}
          >
            <Input
              prefix={<UserOutlined />}
              type="email"
              placeholder="Email"
              onChange={handleEmailChange}
            />
          </Form.Item>

          <Form.Item name="password" rules={[{ validator: validatePassword }]}>
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
