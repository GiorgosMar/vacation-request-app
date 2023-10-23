import { Card, Paper, Typography } from '@mui/material';
import React, { Fragment, useState } from "react";
import { useTheme } from '@mui/material/styles';


const LoginHeader = () => {
    const theme = useTheme();
    const style = {
        logo: {
            margin: theme.spacing(1),
            padding: theme.spacing(1, 2),
            color: theme.palette.primary.main,
            backgroundColor: theme.palette.secondary.main,
            borderRadius: 1,
            border: `2px solid ${theme.palette.primary.main}`,
            display: "flex",
            justifyContent: "center",
            maxWidth: 150
        },

        typographyLogo: {
            fontFamily: ["Roboto", "Lato", "Sans Serif"],
            fontSize: 12,
            lineHeight: 2,
        }
    }

    return (
        <Fragment>
            <Card>
                <Paper sx={style.logo}>
                    <Typography sx={style.typographyLogo}>
                        Vacation Request App
                    </Typography>
                </Paper>
            </Card>
        </Fragment>
    );
};
export default LoginHeader;