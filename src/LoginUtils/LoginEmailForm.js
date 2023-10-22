import { Paper } from '@mui/material';
import React, { Fragment } from "react";
import { useTheme } from '@mui/material/styles';

import Typography from "@mui/material/Typography";

import LoginEmailField from "../LoginUtils/LoginEmailField";

const LoginEmailForm = ({ children, ...props }) => {
    const theme = useTheme();
    const style = {
        form: {
            padding: theme.spacing(10, 10),
            color: theme.palette.loginForm.main,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            borderRadius: 1,
            minWidth: 650,
            minHeight: 700,
        },

        logo: {
            margin: theme.spacing(1),
            padding: theme.spacing(1, 2),
            color: theme.palette.primary.main,
            backgroundColor: theme.palette.secondary.main,
            borderRadius: 1,
            border: `2px solid ${theme.palette.primary.main}`,
            display: "flex",
            justifyContent: "center",
            maxWidth: 300
        },

        typographyLogo: {
            fontFamily: ["Roboto", "Lato", "Sans Serif"],
            fontSize: 20,
            lineHeight: 2,
        },

        typographyLogin: {
            marginTop: theme.spacing(7),
            marginBottom: theme.spacing(2),
            fontFamily: ["Roboto", "Lato", "Sans Serif"],
            fontSize: 30,
            lineHeight: 2,

        }
    }

    return (
        <Fragment>
            <Paper elevation={12} sx={style.form}>
                <Paper sx={style.logo}>
                    <Typography sx={style.typographyLogo}>
                        Vacation Request App
                    </Typography>
                </Paper>
                <Typography variant={'h5'} component={'h1'} sx={style.typographyLogin}>
                    Είσοδος
                </Typography>
                {children}
            </Paper>
        </Fragment>
    );
};
export default LoginEmailForm;