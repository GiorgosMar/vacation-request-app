import { Grid, Card } from '@mui/material';
import React, { Fragment } from "react";
import LoginHeader from '../LoginUtils/LoginHeader';

import CssBaseline from "@mui/material/CssBaseline";

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

  return (
    <Fragment>
      <Grid container flexDirection={'column'} >
        <Grid item>
          <LoginHeader />
        </Grid>

        <Grid item
          sx={{
            display: 'flex',
            justifyContent: 'center'
          }}
          minWidth={"md"}
          >
          <LoginEmailForm />
        </Grid>

      </Grid>
    </Fragment>
  );
};
export default Login;