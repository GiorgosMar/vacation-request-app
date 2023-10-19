import React, { Fragment } from "react";
import { Container } from "@mui/material";


const LoginContainer = ({ children, ...props }) => {
    return (
        <Fragment>
            <Container
                maxWidth="xs"
                sx={{
                    display: 'flex',
                    justifyContent: 'center',
                    flexDirection: "column",
                    alignItems: 'center',
                    height: '100vh'
                }}
                {...props}
            >
                {children}
            </Container>
        </Fragment >
    );
}
export default LoginContainer;