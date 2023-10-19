import { Box } from "@mui/material";
import { Fragment } from "react";

const LoginForm = ({ children, ...props }) => {
    return (
        <Fragment>
            <Box
                component="form"
                noValidate
                sx={{ mt: 1 }}
                {...props}
            >
                {children}
            </Box>
        </Fragment>
    );
}
export default LoginForm;