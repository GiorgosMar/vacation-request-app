import {Alert, Grid} from "@mui/material";
import React, {useState} from "react";
import { useTheme } from "@mui/material/styles";

import Typography from "@mui/material/Typography";
import LoginEmailForm from "../LoginUtils/LoginEmailForm";
import LoginEmailField from "../LoginUtils/LoginEmailField";
import InputAdornment from "@mui/material/InputAdornment";
import LoginButton from "../LoginUtils/LoginButton";
import axios from "axios";

function Copyright(props) {
  return (
    <Typography
      variant="body2"
      color="text.secondary"
      align="center"
      {...props}
    >
      {"Copyright © "}
      {new Date().getFullYear()}
      {"."}
    </Typography>
  );
}

const Login = () => {

    //useState//
    const [inputs, setInputs] = useState({
        email: "",
        password: "",
    });
    const [errorMessage, setErrorMessage] = useState(false);
    const { email, password } = inputs;

  const theme = useTheme();
  const style = {
    form: {
      display: "flex",
      alignItems: "center",
      justifyContent: "center",
    },
  };

    const onSubmitEmail = async (e) => {
        e.preventDefault();
        const body = {email}
        await axios.post("https://reqres.in/api/login", {body})
    };

  return (
      <Grid container style={{height: "100vh"}}>
        <Grid item container sx={style.form}>
          <LoginEmailForm>
            <LoginEmailField
                InputProps={{
                  endAdornment: (
                      <InputAdornment position="end">
                        <LoginButton onClick={onSubmitEmail}  />
                      </InputAdornment>
                  ),
                }}
                value={inputs.email}
                onChange={(e) =>
                    setInputs({
                        ...inputs,
                        email: e.target.value,
                    })
                }
            />
              <Grid sx={{mt:2}}>
                  {errorMessage && (
                      <Alert severity="error"> {errorMessage} </Alert>
                  )}
              </Grid>
          </LoginEmailForm>
        </Grid>
      </Grid>
  );
};
export default Login;
