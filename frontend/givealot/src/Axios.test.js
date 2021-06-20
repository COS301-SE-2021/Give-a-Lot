import React from 'react'
import { render, waitForElement, fireEvent } from '@testing-library/react'
import axiosMock from 'axios'
// import TestAxios from './TestAxios'
import AdminOrgs from "./components/Admin/AdminOrgs"

jest.mock('axios')

it('should display a loading text', () => {

 const { getByTestId } = render(<AdminOrgs />)

  expect(getByTestId('loading')).toHaveTextContent('Loading...')
})

it('should load and display the data', async () => {
  const url = 'https://jsonplaceholder.typicode.com/users'
  const { getByTestId } = render(<AdminOrgs url={url} />)

  axiosMock.get.mockResolvedValueOnce({
    data: { "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz" },
  })

  fireEvent.click(getByTestId('fetch-data'))

  const greetingData = await waitForElement(() => getByTestId('show-data'))

  expect(axiosMock.get).toHaveBeenCalledTimes(1)
  expect(axiosMock.get).toHaveBeenCalledWith(url)
  expect(greetingData).toHaveTextContent('hello there')
})