import React, { Fragment } from "react";
import { TextField } from "@mui/material";
import { useTheme } from "@mui/material/styles";

const LoginEmailField = ({ children, ...props }) => {
  const theme = useTheme();
  const style = {
    emailTextField: {
      fontFamily: ["Arial"],
      color: "#000000",
      opacity: "0.7",
    },
  };

  return (
    <Fragment>
      <TextField
        required
        fullWidth
        id="email"
        label="Email"
        name="email"
        autoComplete="email"
        sx={style.emailTextField}
        {...props}
      >
        {children}
      </TextField>
    </Fragment>
  );
};
export default LoginEmailField;
