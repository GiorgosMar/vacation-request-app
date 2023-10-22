import { Grid } from "@mui/material";
import React, { Fragment } from "react";
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
    const body = { email };
    axios.post("http://localhost:5000/auth/login", { body })
    .then().
    catch();
  };

  return (
    <Fragment>
      <Grid container style={{ height: "100vh" }}>
        <Grid item container sx={style.form}>
          <LoginEmailForm>
            <LoginEmailField
              InputProps={{
                endAdornment: (
                  <InputAdornment position="end">
                    <LoginButton />
                  </InputAdornment>
                ),
              }}
            />
          </LoginEmailForm>
        </Grid>
      </Grid>
    </Fragment>
  );
};
export default Login;
