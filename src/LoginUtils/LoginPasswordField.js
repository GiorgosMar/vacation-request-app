import React, { Fragment } from "react";
import { TextField } from "@mui/material";


const LoginPasswordField = ({ children, ...props }) => {
    return (
        <Fragment>
            <TextField
                inputProps={{
                    style: { fontFamily: "Arial", color: "white" },
                }}
                InputLabelProps={{
                    style: { fontFamily: "Arial", color: "white", opacity: "0.7" },
                }}
                sx={{
                    "& .MuiOutlinedInput-root.Mui-focused": {
                        "& > fieldset": {
                            borderColor: "#57010b"
                        }
                    }
                }}
                style={{ flex: 1, margin: "0 20px 0 0", color: "purple" }}
                margin="normal"
                required
                fullWidth
                name="password"
                label="Εισάγετε κωδικό"
                type="password"
                id="password"
                autoComplete="current-password"
                {...props}
            >
                {children}
            </TextField>
        </Fragment>
    );
}
export default LoginPasswordField;