import React from 'react';
import { View, Button, NativeModules } from 'react-native';
import firebase from '@react-native-firebase/app';
import '@react-native-firebase/analytics';
import { useConfig } from './AppContext';

const Analytics = () => {

    const { flavor } = useConfig();

    const logEvent = (name, bundle) => {
        if (flavor === 'hms') {
            NativeModules.HMSAnalytics.logEvent(name, JSON.stringify(bundle));
        } else {
            firebase.analytics().logEvent(name, bundle);
        }
    }

    return (
        <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
            <Button title={`${flavor}: Send Analytics`} 
                onPress={() => logEvent("test", { message: "hi" })} />
        </View>
    );
};

export default Analytics;
