import { Grid, Paper } from '@mui/material';
import React, { Fragment } from "react";
import { useTheme } from '@mui/material/styles'
import { BorderAllOutlined } from '@mui/icons-material';


const Login = () => {
  const theme = useTheme();
  const style = {
    logo: {
      margin: theme.spacing(3),
      padding: theme.spacing(2, 3),
      color: theme.palette.primary.main,
      backgroundColor: theme.palette.secondary.main,
      borderRadius: 1,
      border: `2px solid ${theme.palette.primary.main}`
    }
  }

  return (
    <Fragment>
      <Grid container>
        <Grid item  >
          <Paper sx={style.logo}>
            Vacation Request App
          </Paper>
        </Grid>
      </Grid>
    </Fragment>
  );
};
export default Login;