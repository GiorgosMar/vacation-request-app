import React, { Fragment } from "react";
import { Box } from "@mui/material";


const LoginGridBox = ({ children, ...props }) => {
    return (
        <Fragment>
            <Box
                disableGutters={true}
                sx={{
                    display: "flex",
                    flexDirection: "column",
                    alignItems: "center",
                    backgroundColor: "rgba(0,0,0,.5)",
                    color: "#fff",
                    borderRadius: "10%",
                    padding: "20px",

                }}
                {...props}
            >
                {children}
            </Box>
        </Fragment >
    );
}
export default LoginGridBox;