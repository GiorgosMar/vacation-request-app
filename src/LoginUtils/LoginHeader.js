import { Card, Paper } from '@mui/material';
import React, { Fragment, useState } from "react";
import { useTheme } from '@mui/material/styles';


const LoginHeader = () => {
    const theme = useTheme();
    const style = {
        logo: { 
            margin: theme.spacing(2),
            padding: theme.spacing(2, 3),
            color: theme.palette.primary.main,
            backgroundColor: theme.palette.secondary.main,
            borderRadius: 1,
            border: `2px solid ${theme.palette.primary.main}`,
            display: "flex",
            justifyContent: "center",
            maxWidth: 220
        }
    }

    return (
        <Fragment>
            <Card>
                <Paper sx={style.logo}>
                    Vacation Request App
                </Paper>
            </Card>
        </Fragment>
    );
};
export default LoginHeader;