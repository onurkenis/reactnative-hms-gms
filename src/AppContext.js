import React, { useContext, useState } from "react";
import { NativeModules } from 'react-native';

const Config = React.createContext({
    flavor: ""
});

export const useConfig = () => useContext(Config);

export const AppContext = ({ children }) => {
    const [flavor, setFlavor] = useState("");

    async function getFlavor() {
        try {
            const { flavor } = await NativeModules.BuildConfigTest.getFlavor();
            setFlavor(flavor);
        } catch (e) {
            console.error(e);
        }
    }

    getFlavor();

    const context = { flavor };

    return (
        <Config.Provider value={context}>{children}</Config.Provider>
    );
};
