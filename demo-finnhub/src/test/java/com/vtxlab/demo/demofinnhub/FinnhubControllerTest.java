package com.vtxlab.demo.demofinnhub;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.vtxlab.demo.demofinnhub.model.CompanyDTO;
import com.vtxlab.demo.demofinnhub.model.CompanyProfile;
import com.vtxlab.demo.demofinnhub.service.FinnhubService;

@WebMvcTest
public class FinnhubControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private FinnhubService finnhubService;

        @Test
        void testGetCompanyDTO() throws Exception {
                String symbol = "AAPL";
                CompanyProfile companyProfile = new CompanyProfile("US", "Apple Inc", "1980-12-12",
                                "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/AAPL.svg",
                                2782424.256787212,
                                "USD");
                CompanyDTO companyDTO = new CompanyDTO(companyProfile, 177.97, 179.38, 176.44, 176.48, 175.01);
                Mockito.when(finnhubService.getCompanyDTO(symbol)).thenReturn(companyDTO);

                // ResultActions mvcResult =
                // mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customer2"));

                mockMvc.perform(get("/api/v1/stock?symbol=AAPL")).andExpect(status().isOk())
                                .andExpect(content().contentType("application/json"))
                                .andExpect(jsonPath("$.data.companyProfile.country").value("US"))
                                .andExpect(jsonPath("$.data.companyProfile.companyName").value("Apple Inc"))
                                .andExpect(jsonPath("$.data.companyProfile.ipoDate").value("1980-12-12"))
                                .andExpect(jsonPath("$.data.companyProfile.logo")
                                                .value("https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/AAPL.svg"))
                                .andExpect(jsonPath("$.data.companyProfile.marketCap").value("2782424.256787212"))
                                .andExpect(jsonPath("$.data.companyProfile.currency").value("USD"))
                                .andExpect(jsonPath("$.data.currentPrice").value("177.97"))
                                .andExpect(jsonPath("$.data.dayHigh").value("179.38"))
                                .andExpect(jsonPath("$.data.dayLow").value("176.44"))
                                .andExpect(jsonPath("$.data.dayOpen").value("176.48"))
                                .andExpect(jsonPath("$.data.prevDayClose").value("175.01"));
        }

        @Test
        void testEmptyCompanyDTO() throws Exception {
                String symbol = "ABC";
                Mockito.when(finnhubService.getCompanyDTO(symbol)).thenReturn(null);

                mockMvc.perform(get("/api/v1/stock?symbol=AAPL")).andExpect(status().isBadRequest())
                                .andExpect(content().contentType("application/json"))
                                .andExpect(jsonPath("$.data.companyProfile.country").doesNotExist())
                                .andExpect(jsonPath("$.data.companyProfile.companyName").doesNotExist())
                                .andExpect(jsonPath("$.data.companyProfile.ipoDate").doesNotExist())
                                .andExpect(jsonPath("$.data.companyProfile.logo")
                                                .doesNotExist())
                                .andExpect(jsonPath("$.data.companyProfile.marketCap").doesNotExist())
                                .andExpect(jsonPath("$.data.companyProfile.currency").doesNotExist())
                                .andExpect(jsonPath("$.data.currentPrice").doesNotExist())
                                .andExpect(jsonPath("$.data.dayHigh").doesNotExist())
                                .andExpect(jsonPath("$.data.dayLow").doesNotExist())
                                .andExpect(jsonPath("$.data.dayOpen").doesNotExist())
                                .andExpect(jsonPath("$.data.prevDayClose").doesNotExist());
        }

}
