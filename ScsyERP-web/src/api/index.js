import { DEBUG } from '../util'

import axios from 'axios'

export const ENDPOINT = '120.76.219.196:8082'

import store from '../store'

export const handlers = {
    error: null
}

const handleResponse = ({ data }, { showSuccessMessage = false } = {}) => {
    if (data.status !== 0) {
        if (data.msg !== '第1页不存在') {
            handlers.error(data)
        }
        throw new Error(data.msg)
    } else if (showSuccessMessage) {
        handlers.success(data)
    }
    return data.content
}

const handleResponse_NOERROR = ({ data }, { showSuccessMessage = false } = {}) => {
    if (data.status !== 0) {
        if (data.msg !== '第1页不存在') {
            handlers.error(data)
        }
        return null;
    } else if (showSuccessMessage) {
        handlers.success(data)
    }
    return data.content
}

const encode = encodeURIComponent
const Qs = require('qs');
// export const POSTKV = (path, data) => axios.post(`http://${ENDPOINT}${path}`, data, {
//     headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
//     // headers: { 'Content-Type': 'application/json' }
//     // transformRequest: (data = {}) => {
//     //     return !data ? '' : Object.keys(data).reduce((result, key) => result + `${encode(key)}=${encode(data[key])}&`, '').slice(0, -1)
//     // }
//     transformRequest:[function (data){
//         data = Qs.stringify({data:JSON.stringify(data)});
//         return data;
//     }]
// }).then(data => handleResponse(data, { showSuccessMessage: true }))

export const POST = (path, data) => axios.post(`http://${ENDPOINT}${path}`, data, {
    headers: { 'Content-Type': 'application/x-www-form-urlencoded', 'Access-Control-Allow-Origin': '*', 'Access-Control-Allow-Method': 'POST' },
    transformRequest: (data = {}) => {
        if(data){
            for(let x in data){
                if(!data[x])
                    delete(data[x]);
            }
        }
        return !data ? '' : Object.keys(data).reduce((result, key) => result + `${encode(key)}=${encode(data[key])}&`, '').slice(0, -1)
    }
}).then(data => handleResponse(data, { showSuccessMessage: true }))

export const GET = (path, params) => axios.get(`http://${ENDPOINT}${path}`, {
    headers: { 'Access-Control-Allow-Origin': '*' },
    params: {
        Corporation: store.getters.user.Corporation,
        ...params,
    }
}).then(handleResponse)

export const GET_NOERROR = (path, params) => axios.get(`http://${ENDPOINT}${path}`, {
    params: {
        Corporation: store.getters.user.Corporation,
        ...params,
    }
}).then(handleResponse_NOERROR)

if (DEBUG) {
    window.axios = axios
    window.setUserFromCookie = cookie => {
        store.commit('receiveUser', cookie.split('; ').reduce((obj, pair) => {
            let [key, value] = pair.split('=')
            if (key === 'type') value = parseInt(value)
            obj[key] = value
            return obj
        }, {}))
    }
    window.post = POST
    window.get = GET
}

// export const socket = new WebSocket(`ws://${ENDPOINT}/wsshake`)
// socket.onerror = msg => {app.$notify.error({ title: 'socket错误', message: msg })}
