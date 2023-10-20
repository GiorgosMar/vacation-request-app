import { Grid } from '@mui/material';
import React, { Fragment } from "react";
import { useTheme } from '@mui/material/styles';


import Typography from "@mui/material/Typography";
import LoginEmailForm from '../LoginUtils/LoginEmailForm';

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
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
    }
  }


  return (
    <Fragment>
      <Grid container style={{ height: '100vh' }} >
        <Grid item
          container
          sx={style.form}
        >
          <LoginEmailForm />
        </Grid>
      </Grid>
    </Fragment>
  );
};
export default Login;