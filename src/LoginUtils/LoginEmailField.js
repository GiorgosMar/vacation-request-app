import React, { Fragment } from "react";
import { TextField } from "@mui/material";

const LoginEmailField = ({ children, ...props }) => {

    return (
        <Fragment>
            <TextField
                inputProps={{
                    style: {
                        fontFamily: "Arial",
                        color: "white",
                    },
                }}
                InputLabelProps={{
                    style: { fontFamily: "Arial", color: "white", opacity: "0.7", }
                }}
                sx={{
                    "& .MuiOutlinedInput-root.Mui-focused": {
                      "& > fieldset": {
                        borderColor: "#57010b"
                      }
                    }
                  }}
                margin="normal"
                required
                fullWidth
                id="email"
                label="Εισάγετε Email"
                name="email"
                autoComplete="email"
                {...props}
            >
                {children}
            </TextField>
        </Fragment>
    );
}
export default LoginEmailField;