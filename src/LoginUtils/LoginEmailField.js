import React, { Fragment } from "react";
import { Input, TextField } from "@mui/material";
import { useTheme } from '@mui/material/styles';

import InputAdornment from '@mui/material/InputAdornment';



import LoginButton from "./LoginButton";

const LoginEmailField = ({ children, ...props }) => {
    const theme = useTheme();
    const style = {
        emailTextField: {
            fontFamily: ["Arial"],
            color: '#000000',
            opacity: '0.7',
        },
    }

    return (
        <Fragment>
            <TextField
                required
                fullWidth
                id="email"
                label="Email"
                name="email"
                autoComplete="email"
                {...props}
                sx={style.emailTextField}
                InputProps={{
                    endAdornment: (
                      <InputAdornment position="end">
                        <LoginButton/>
                      </InputAdornment>
                    ),
                  }}
            >
                {children}
            </TextField>
        </Fragment>
    );
}
export default LoginEmailField;