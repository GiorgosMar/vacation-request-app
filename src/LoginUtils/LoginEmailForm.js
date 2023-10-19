import { Paper } from '@mui/material';
import React, { Fragment } from "react";
import { useTheme } from '@mui/material/styles';


import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import Avatar from "@mui/material/Avatar";


const LoginEmailForm = () => {
    const theme = useTheme();
    const style = {
        form: {
            margin: theme.spacing(2),
            padding: theme.spacing(2, 3),
            color: theme.palette.primary.main,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            borderRadius: 0,
        }
    }

    return (
        <Fragment>
            <Paper elevation={12} sx={style.form}>
                <Avatar>
                    <LockOutlinedIcon />
                </Avatar>
                <Typography component="h1" variant="h5">
                    Είσοδος
                </Typography>
            </Paper>
        </Fragment>
    );
};
export default LoginEmailForm;