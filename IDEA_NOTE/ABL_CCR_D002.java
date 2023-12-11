package com.welgram.crawler.direct.life.abl;

import com.welgram.common.WaitUtil;
import com.welgram.crawler.general.CrawlingProduct;

import org.openqa.selenium.*;



// 서용호 | ABL인터넷나를위한5대미니암보험
public class ABL_CCR_D002 extends CrawlingABLDirect {

    public static void main(String[] args) {
        executeCommand(new ABL_CCR_D002(), args);
    }



    @Override
    protected boolean scrap(CrawlingProduct info) throws Exception {

        logger.info("성별 클릭");
        setGender(info.gender);

        logger.info("생년월일 입력");
        setBirthday(info.fullBirth);

        logger.info("보험료 확인하기 클릭");
        driver.findElement(By.id("calcStrBtn")).click();
        waitLoadingImg();

        logger.info("내맘대로 설계하기 클릭");
        driver.findElement(By.id("direcEntplTab")).click();

        logger.info("가입금액 1000만원(고정)");

        logger.info("보험기간 클릭");
        setInsTerm(info.insTerm);

        logger.info("납입기간 클릭");
        setNapTerm(info.napTerm);

        logger.info("납입주기 클릭");
        setNapCycle(info.napCycle);

        logger.info("보험료 계산");
        crawlPremium(info);

        logger.info("스크린샷");
        takeScreenShot(info);

        logger.info("해약환급금 클릭");
        driver.findElement(By.id("srdvl00Btn")).click();
        WaitUtil.waitFor(3);
        crawlReturnMoneyList(info);

        return true;
    }

}
//    @Override
//    protected boolean scrap(CrawlingProduct info) throws Exception {
//
//        webCrawling(info);
//        return true;
//    }
    // 공시실 ( https://www.abllife.co.kr/hp/pban/insPrcPban )
//    private boolean webCrawling(CrawlingProduct info) throws Exception {
//
//        boolean result = false;
//
//        logger.info("공시실 크롤링 시작!");
//        startDriver(info);
//
//        // 공시실
//        openAnnouncePage(info);
//
//        // 성별
//        setGender(info.gender);
//
//        // 생년월일
//        setBirth(By.id("insrdSno_jupiDate1"), info.fullBirth);
//
//        // 계약관계정보 적용
//        doClickButton(By.id("applyContRltnInfo"));
//
//        // 가입금액
//        setAssuredPremium(info.assureMoney);
//
//        for (CrawlingTreaty item : info.treatyList) {
//            if (item.productGubun.equals(ProductGubun.주계약)) {
//                String mainTitle = driver.findElement(By.id("mainTitle")).getText();
//
//                if (mainTitle.indexOf(item.treatyName) > -1) {
//                    info.siteProductMasterCount++;
//                }
//
//            } else {
//                logger.info(item.productGubun.toString());
//                setSubTreaty(info, item.treatyName, item.assureMoney / 10000, item.insTerm, item.napTerm);
//            }
//        }
//
//        // 상품마스터 추가
//
//        // 보험료계산
//        calculation("calcPremium", info);
//
//        // 해약환급금
//        getReturnPremium(info);
//
//        // 보험료
//        logger.info("보험료 가져오기");
//        for (CrawlingTreaty item : info.treatyList) {
//            if (item.productGubun.equals(ProductGubun.주계약)) {
//                logger.info(item.productGubun.toString());
//                getMainPremium(item);
//            } else {
//                logger.info(item.productGubun.toString());
//                getSubPremium(item, By.id("settriderTable"));
//            }
//        }
//
//        // getPremium(info);
//
//        result = true;
//
//        return result;
//    }

    // 사용자웹

//        String selectpac = "designmyown"; // 패키지 설계 (package) or 내맘대로 설계(designmyown)
//
//        logger.info("==================");
//        logger.info("사용자웹 크롤링 시작!");
//        logger.info("==================");
//
//        // 성별선택
//        logger.info("=> 성별 선택");
//        WebsetGender(info.gender);
//        WaitUtil.waitFor(2);
//
//        // 생일입력
//        logger.info("=> 생년월일 입력 :: " + info.fullBirth);
//        WebsetBirth(info.fullBirth);
//        WaitUtil.waitFor(2);
//
//        // 보험료 확인하기
//        logger.info("=> 보험료 확인하기 클릭 ");
//        driver.findElement(By.id("calcStrBtn")).click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("globalLoadingDiv")));
//        WaitUtil.waitFor(2);
//
//        if (selectpac.equals("package")) { // 패키지 설계하기 or 내맘대로 설계하기 분기
//
//            /* 패키지로 설계하기 */
//            // 주계약 + 특약 선택
//            for (CrawlingTreaty item : info.treatyList) {
//                int assureMoneychk = 0;
//                // 주계약이라면
//                if (item.productGubun.equals(ProductGubun.주계약)) {
//                    logger.info("---" + item.productGubun.toString() + "---");
//                    helper.doClick(By.cssSelector("#mnContEntAmt02"));
//                    elements = driver.findElements(By.cssSelector("#mnContEntAmt02 > option"));
//
//                    //주계약 가입금액 선택!
//                    for (WebElement option : elements) {
//                        if (option.getText().replace(",", "").replace("만원", "")
//                            .equals(Integer.toString(item.assureMoney / 10000))) {
//                            assureMoneychk++;
//                            logger.info(item.treatyName + " :: " + option.getText() + "클릭!");
//                            option.click();
//                        }
//                    }
//
//                    // 주계약에 해당하는 가입금액이 존재하지 않을 경우
//                    if (assureMoneychk == 0) {
//                        logger.info(item.assureMoney / 10000 + "만원 :: 선택할 수 없습니다.");
//                    }
//
//                } else { // 서브특약
//                    logger.info("---" + item.productGubun.toString() + "---");
//                    logger.info(item.treatyName + " :: ");
//                    if (!WebsetSubTreaty(item.assureMoney / 10000)) { // 특약가입금액이 존재하지 않는다면
//                    }
//                }
//            }
//
//            // 보험료 다시 계산
//            calculation("calcPrm02Btn", info);
//
//            // 보험료 미달인 alert 처리
//            element = driver
//                .findElement(By.cssSelector("#alertMsgBox > div.pop-layer > div > strong"));
//            if (element.isDisplayed()) {
//                if (element.getText().contains("고객님")) {
//                    if (info.gender == 1) {
//                        logger.info("성별 :: 여자");
//                    } else {
//                        logger.info("성별 :: 남자");
//                    }
//                    logger.info("생년월일 :: " + info.fullBirth);
//                    logger.info(element.getText());
//                }
//            }
//
//            /* 패키지로 설계하기 */
//            // 보험료
//            logger.info("보험료 가져오기");
//            WebgetPremium(info);
//
//            // 스크린샷 추가
//            logger.info("스크린샷!");
//            takeScreenShot(info);
//
//            /* 패키지로 설계하기 */
//            // 해약환급금
//            logger.info("=> 해약환급금 조회");
//            WebgetReturnPremium(info);
//
//        } else {
//            /* 내맘대로 설계하기 */
//            // 주계약 + 특약 선택
//            helper.doClick(By.cssSelector("#direcEntplTab > a"));
//            logger.info("내맘대로 설계하기 클릭!");
//
////            for (CrawlingTreaty item : info.treatyList) {
////                int assureMoneychk = 0;
////                // 주계약이라면
////                if (item.productGubun.equals(ProductGubun.주계약)) {
////                    logger.info("---" + item.productGubun.toString() + "---");
////                    helper.doClick(By.cssSelector("#mnContEntAmt00"));
////                    elements = driver.findElements(By.cssSelector("#mnContEntAmt00 > option"));
////
////                    //주계약 가입금액 선택!
////                    for (WebElement option : elements) {
////                        if (option.getText().replace(",", "").replace("만원", "")
////                            .equals(Integer.toString(item.assureMoney / 10000))) {
////                            assureMoneychk++;
////                            logger.info(item.treatyName + " :: " + option.getText() + "클릭!");
////                            option.click();
////                        }
////                    }
////
////                    // 주계약에 해당하는 가입금액이 존재하지 않을 경우
////                    if (assureMoneychk == 0) {
////                        logger.info("주계약 :: " + item.assureMoney / 10000 + "만원 :: 선택할 수 없습니다.");
////                        return result;
////                    }
////
////                } else { // 서브특약
////                    logger.info("특약추가 클릭!");
////                    helper.doClick(By.cssSelector("#trtyPlusBtn > a"));
////                    logger.info("---" + item.productGubun.toString() + "---");
////                    logger.info(item.treatyName + " :: ");
////                    if (!WebusersetSubTreaty(item.assureMoney / 10000,
////                        item.treatyName.trim())) { // 특약가입금액이 존재하지 않는다면
////                        return result;
////                    }
////                }
////            }
//
//            // 내맘대로 설계하기 - 보험기간 선택
//            designmyowninsTerm(info);
//
//            // 내맘대로 설계하기 - 납입기간 선택
//            designmyownnapTerm(info);
//
//            // 보험료 다시 계산
//            calculation("calcPrm00Btn", info);
//
//            // 보험료 미달인 alert 처리
//            element = driver
//                .findElement(By.cssSelector("#alertMsgBox > div.pop-layer > div > strong"));
//            if (element.isDisplayed()) {
//                if (element.getText().contains("고객님")) {
//                    if (info.gender == 1) {
//                        logger.info("성별 :: 여자");
//                    } else {
//                        logger.info("성별 :: 남자");
//                    }
//                    logger.info("생년월일 :: " + info.fullBirth);
//                    logger.info(element.getText());
//                }
//            }
//
//            /* 내맘대로 설계하기 */
//            // 보험료
//            logger.info("보험료 가져오기");
//            WebusergetPremium(info);
//
//            // 스크린샷 추가
//            logger.info("스크린샷!");
//            takeScreenShot(info);
//
//            /* 내맘대로 설계하기 */
//            // 해약환급금
//            logger.info("=> 해약환급금 조회");
//            WebusergetReturnPremium(info);
//
//        }
//    protected void getReturnPremium(CrawlingProduct info) throws Exception {
//        element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnEntplRprtPbl")));
//        element.click();
//        WaitUtil.loading(3);
//
//        Set<String> windowId = driver.getWindowHandles();
//        Iterator<String> handles = windowId.iterator();
//
//        String currentHandle = driver.getWindowHandle();
//        String nextHandle = null;
//
//        while (handles.hasNext()) {
//            nextHandle = handles.next();
//            WaitUtil.loading(2);
//        }
//
//        driver.switchTo().window(nextHandle);
//
//        element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tabRefnd")));
//        element.click();
//        helper.waitForCSSElement(".state-load-data");
//
//        int num = 0;
//        String text = "";
//
//        if (info.productCode.equals("ABL00099")) {
//            text = "해약환급금(투자수익률3.75%)";
//        } else {
//            text = "해약환급금(공시이율)";
//        }
//
//        WaitUtil.loading(3);
//        element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("refndTab")));
//        List<WebElement> thElements = element.findElements(By.cssSelector("table thead th"));
//        for (int i = 0; i < thElements.size(); i++) {
//            if (thElements.get(i).getText().replace("\n", "").equals(text)) {
//                num = i;
//                break;
//            }
//        }
//
//        element = element.findElement(By.tagName("table")).findElement(By.tagName("tbody"));
//        elements = element.findElements(By.tagName("tr"));
//
//        List<PlanReturnMoney> planReturnMoneyList = new ArrayList<PlanReturnMoney>();
//        for (WebElement tr : elements) {
//            PlanReturnMoney planReturnMoney = new PlanReturnMoney();
//            String term = tr.findElements(By.tagName("td")).get(0).getText();
//            String premiumSum = tr.findElements(By.tagName("td")).get(2).getText();
//            String returnMoney = tr.findElements(By.tagName("td")).get(3).getText();
//            String returnRate = tr.findElements(By.tagName("td")).get(4).getText();
//            logger.info(term + " :: " + premiumSum);
//
//            planReturnMoney.setTerm(term);
//            planReturnMoney.setPremiumSum(premiumSum);
//            planReturnMoney.setReturnMoney(returnMoney);
//            planReturnMoney.setReturnRate(returnRate);
//            planReturnMoneyList.add(planReturnMoney);
//
//            // 기본 해약환급금 세팅
//            info.returnPremium = tr.findElements(By.tagName("td")).get(3).getText()
//                .replace(",", "");
//        }
//
//        info.setPlanReturnMoneyList(planReturnMoneyList);
//
//        info.savePremium = "0"; // 적립보험료
//        // info.treatyList.get(0).monthlyPremium = "0"; // 납입보험료
//        info.errorMsg = "";
//
//        driver.close();
//        driver.switchTo().window(currentHandle);
//    }
//
//    /* 패키지로 설계하기 */
//    // 사용자웹 - 서브 특약
//    protected boolean WebsetSubTreaty(int assureMoney) throws Exception {
//        boolean returnresult = true;
//
//        helper.doClick(By.cssSelector("#trtyEntAmt020"));
//        elements = driver.findElements(By.cssSelector("#trtyEntAmt020 > option"));
//        int subtreaty = 0;
//
//        for (WebElement option : elements) {
//            if (option.getText().replace(",", "").replace("만원", "")
//                .equals(Integer.toString(assureMoney))) {
//                logger.info(option.getText() + "클릭!");
//                subtreaty++;
//                option.click();
//            }
//        }
//
//        if (subtreaty == 0) { // 특약가입금액이 존재하지 않을 경우
//            logger.info(assureMoney + "만원 :: 선택할 수 없습니다.");
//            returnresult = false;
//        }
//
//        return returnresult;
//    }
//
//    /* 내맘대로 설계하기 */
//    // 사용자웹 - 서브 특약
//    protected boolean WebusersetSubTreaty(int assureMoney, String subtreatyname) {
//        boolean returnresult = true;
//
//        elements = driver.findElements(By.cssSelector("#trtyList00Div > li"));
//        int subtreaty = 0;
//
//        for (WebElement li : elements) {
//            String websubtreatyname = li.findElements(By.tagName("span")).get(0).getText().trim();
//            WebElement selectboxsubtreaty = li.findElements(By.tagName("span")).get(1);
//            elements = selectboxsubtreaty.findElements(By.tagName("option"));
//
//            if (subtreatyname.contains(websubtreatyname)) { // 특약명이 같다면
//                for (WebElement option : elements) { // 특약의 금액 selectbox
//                    if (option.getText().replace(",", "").replace("만원", "")
//                        .equals(Integer.toString(assureMoney))) { // 특약명의 금액이 같다면
//                        logger.info(option.getText() + "클릭!");
//                        subtreaty++;
//                        option.click();
//                    }
//                }
//            }
//        }
//
//        if (subtreaty == 0) { // 특약가입금액이 존재하지 않을 경우
//            logger.info(assureMoney + "만원 :: 선택할 수 없습니다.");
//            returnresult = false;
//        }
//
//        return returnresult;
//    }
//
//
//    // 공시실 - 서브 특약
//    protected void setSubTreaty(CrawlingProduct info, String treatyName, int assureMoney,
//        String insTerm, String napTerm)
//        throws Exception {
//        boolean result = false;
//
//        element = helper.waitPresenceOfElementLocated(By.id("trtyTable"));
//        elements = element.findElements(By.cssSelector("tbody > tr"));
//
//        // 주보험 영역 Tr 개수만큼 loop
//        for (WebElement tr : elements) {
//            String prdtNm = tr.findElements(By.tagName("td")).get(1).getText();
//            // 담보명과 이름이 같은지 확인
//            if (treatyName.indexOf(prdtNm) > -1) {
//                info.siteProductMasterCount++; // 등록된 담보명과 같은지 검증하는 카운트
//                // 같으면 보기, 납기, 가입금액을 셋한다.
//
//                element = tr.findElements(By.tagName("td")).get(0)
//                    .findElement(By.cssSelector("input[type='checkbox']"));
//                // 선택박스 처리
//                if (!element.isSelected()) {
//                    element.click();
//                    logger.info(treatyName + " 특약 click!");
//                }
//
//                // 가입금액 세팅
//                element = tr.findElements(By.tagName("td")).get(4).findElement(By.tagName("input"));
//                Thread.sleep(200);
//                element.sendKeys(Keys.BACK_SPACE);
//                Thread.sleep(200);
//                element.sendKeys(Keys.BACK_SPACE);
//                Thread.sleep(200);
//                element.sendKeys(Keys.BACK_SPACE);
//                Thread.sleep(200);
//                element.sendKeys(Keys.BACK_SPACE);
//                Thread.sleep(200);
//                element.sendKeys(Keys.BACK_SPACE);
//
//                Thread.sleep(200);
//                element.sendKeys(assureMoney + "");
//                element.sendKeys(Keys.TAB);
//
//            }
//            if (result) {
//                break;
//            }
//        }
//    }
//
//    /* 패키지로 설계하기 */
//    // 사용자 웹 - 해약환급금 세팅
//    protected void WebgetReturnPremium(CrawlingProduct info) throws Exception {
//
//        // 기본 해약환급금 세팅
//        driver.findElement(By.id("srdvl02Btn")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tabBtn02 > a")))
//            .click();
//
//        // 전체기간 확인하기
//        logger.info("전체기간 확인하기 클릭!");
//        helper.doClick(By.cssSelector("#tab_area_box_2 > div.acc_solo > div > a"));
//        WaitUtil.loading();
//
//        List<PlanReturnMoney> planReturnMoneyList = new ArrayList<>();
//
//        List<WebElement> trElements = driver.findElements(By.cssSelector("#rscRefndList1 > tr"));
//        for (WebElement tr : trElements) {
//            PlanReturnMoney planReturnMoney = new PlanReturnMoney();
//            String term = tr.findElements(By.tagName("td")).get(0).getAttribute("innerText");
//            String premiumSum = tr.findElements(By.tagName("td")).get(1).getAttribute("innerText");
//            String returnMoney = tr.findElements(By.tagName("td")).get(2).getAttribute("innerText");
//            String returnRate = tr.findElements(By.tagName("td")).get(3).getAttribute("innerText");
//            logger.info(term + " :: " + premiumSum);
//
//            planReturnMoney.setTerm(term);
//            planReturnMoney.setPremiumSum(premiumSum);
//            planReturnMoney.setReturnMoney(returnMoney);
//            planReturnMoney.setReturnRate(returnRate);
//            planReturnMoneyList.add(planReturnMoney);
//
//            // 기본 해약환급금 세팅
//            info.returnPremium = returnMoney.replace(",", "");
//        }
//        info.setPlanReturnMoneyList(planReturnMoneyList);
//    }
//
//    /* 내맘대로 설계하기 */
//    // 사용자 웹 - 해약환급금 세팅
//    protected void WebusergetReturnPremium(CrawlingProduct info) throws Exception {
//
//        // 기본 해약환급금 세팅
//        driver.findElement(By.id("srdvl00Btn")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tabBtn02 > a")))
//            .click();
//
//        // 전체기간 확인하기
//        logger.info("전체기간 확인하기 클릭!");
//        helper.doClick(By.cssSelector("#tab_area_box_2 > div.acc_solo > div > a"));
//        WaitUtil.loading();
//
//        List<PlanReturnMoney> planReturnMoneyList = new ArrayList<>();
//
//        List<WebElement> trElements = driver.findElements(By.cssSelector("#rscRefndList1 > tr"));
//        for (WebElement tr : trElements) {
//            PlanReturnMoney planReturnMoney = new PlanReturnMoney();
//            String term = tr.findElements(By.tagName("td")).get(0).getAttribute("innerText");
//            String premiumSum = tr.findElements(By.tagName("td")).get(1).getAttribute("innerText");
//            String returnMoney = tr.findElements(By.tagName("td")).get(2).getAttribute("innerText");
//            String returnRate = tr.findElements(By.tagName("td")).get(3).getAttribute("innerText");
//            logger
//                .info(term + " :: " + "보험료 ::" + premiumSum + " || " + " 해약환급금 :: " + returnMoney);
//
//            planReturnMoney.setTerm(term);
//            planReturnMoney.setPremiumSum(premiumSum);
//            planReturnMoney.setReturnMoney(returnMoney);
//            planReturnMoney.setReturnRate(returnRate);
//            planReturnMoneyList.add(planReturnMoney);
//
//            // 기본 해약환급금 세팅
//            info.returnPremium = returnMoney.replace(",", "");
//        }
//        info.setPlanReturnMoneyList(planReturnMoneyList);
//    }
//
//    /* 패키지로 설계하기 */
//    // 사용자 웹 - 보험료 가져오기
//    public void WebgetPremium(CrawlingProduct info) {
//        String result = driver.findElement(By.id("vwMnContPrm02")).getAttribute("innerText")
//            .replace(",", "");
//        info.treatyList.get(0).monthlyPremium = MoneyUtil.toDigitMoney(result).toString();
//        logger.info("보험료: :: " + result);
//    }
//
//    /* 내맘대로 설계하기 */
//    // 사용자 웹 - 보험료 가져오기
//    public void WebusergetPremium(CrawlingProduct info) {
//        String result = driver.findElement(By.id("vwMnContPrm00")).getAttribute("innerText")
//            .replace(",", "");
//        info.treatyList.get(0).monthlyPremium = MoneyUtil.toDigitMoney(result).toString();
//        logger.info("보험료: :: " + result);
//    }
//
//    public boolean isAlertShowed() {
//        try {
//            Alert alert = new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
//            if (alert != null) {
//                // driver.switchTo().alert().accept();
//                return true;
//            } else {
//                throw new Throwable();
//            }
//        } catch (Throwable e) {
//            return false;
//        }
//    }
