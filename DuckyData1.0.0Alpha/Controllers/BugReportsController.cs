﻿using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using DuckyData1._0._0Alpha.Models;
using DuckyData1._0._0Alpha.Factory.BugReports;
using DuckyData1._0._0Alpha.ViewModels;
using System.Web.Security;
using Microsoft.AspNet.Identity;
using System.Web.Routing;
using PagedList;
using DuckyData1._0._0Alpha.Factory.FollowUps;
using DuckyData1._0._0Alpha.ViewModels.FollowUps;
using DuckyData1._0._0Alpha.Factory.WebAPI.Gracenote;
using System.Threading.Tasks;

namespace DuckyData1._0._0Alpha.Controllers
{
    public class BugReportsController :Controller
    {
        private ApplicationDbContext db = new ApplicationDbContext();
        private BugRereportFactory bugRereportFactory = new BugRereportFactory();
        private FollowUpsFactory followUpsFactory = new FollowUpsFactory();
        // GET: BugReports
        [Authorize(Roles = "Admin, TechSupport")]
        public ActionResult Index(int? page)
        {
            var bugList = TempData["bugList"] as List<BugReportList>;
            if(bugList == null) {
                bugList = bugRereportFactory.getBugReports(null);
            }
            int pageSize = 20;
            int pageNumber = (page ?? 1);
            return View(bugList.ToPagedList(pageNumber,pageSize));
        }

        public ActionResult searchBug(string query)
        {
            List<BugReportList> bugList = bugRereportFactory.getBugReports(query);
            TempData["bugList"] = bugList.ToList();
            return RedirectToAction("Index");
        }


        // GET: BugReports/Details/5
        // view buy report and followup associaed
        [Authorize(Roles = "Admin, TechSupport")]
        public ActionResult Details(int? id)
        {
            if(id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            var bugReport = bugRereportFactory.findBugReprtById(id);
            if(bugReport == null)
            {
                return HttpNotFound();
            }
            
            return View(bugReport);
        }

        // GET: BugReports/Create
        [Authorize]
        public ActionResult Create()
        {
            return View();
        }

        // POST: BugReports/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        [Authorize]
        public async Task<ActionResult> Create(BugReportAdd bugReport)
        {
            if(ModelState.IsValid)
            {
                string userId = User.Identity.GetUserId();
                bugRereportFactory.createBugReport(bugReport,userId);
                Service.EmailService.AppEmailService service = new Service.EmailService.AppEmailService();
                await service.SendBugReportCreated(User.Identity.Name);
                return RedirectToAction("Index","Home");
            }

            return View(bugReport);
        }

        // GET: BugReports/Edit/5
        [Authorize(Roles = "Admin, TechSupport")]
        public ActionResult Edit(int? id)
        {
            if(id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            var bugReport = bugRereportFactory.findBugReprtForEdit(id);

            if(bugReport == null)
            {
                return HttpNotFound();
            }
            return View(bugReport);
        }

        // POST: BugReports/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [Authorize(Roles = "Admin, TechSupport")]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit(BugReport bugReport)
        {
            Service.EmailService.AppEmailService service = new Service.EmailService.AppEmailService();
            
            var user = bugRereportFactory.findBugOwnerByBugId(bugReport.Id);
            await service.SendEditBugReportStatus(user.UserName);
            bugRereportFactory.closeTheBugReport(bugReport.Id);
           
            return RedirectToAction("Details","BugReports",new { id = bugReport.Id });
        }

        // GET: BugReports/Delete/5
        [Authorize(Roles = "Admin, TechSupport")]
        public ActionResult Delete(int? id)
        {
            if(id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            BugReport bugReport = db.BugReports.Find(id);
            if(bugReport == null)
            {
                return HttpNotFound();
            }
            return View(bugReport);
        }

        // POST: BugReports/Delete/5
        [Authorize(Roles = "Admin, TechSupport")]
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            BugReport bugReport = db.BugReports.Find(id);
            db.BugReports.Remove(bugReport);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        [HttpGet]
        [Authorize(Roles = "Admin, TechSupport")]
        // GET: BugReports/FollowUps/5
        public ActionResult FollowUps(int? id) {
            if(id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            BugReport bugReport = bugRereportFactory.findBugReprtOnlyById(id);

            FollowUpAddForm newFollowUp = new FollowUpAddForm();
            newFollowUp.report = bugReport;
            if(bugReport == null)
            {
                return HttpNotFound();
            }

            return View(newFollowUp);
        }

    
        [HttpPost]
        [Authorize(Roles = "Admin, TechSupport")]
        // POST: BugReports/FollowUps/5
        public ActionResult FollowUps(FollowUpAddForm newFollowUp)
        {
            if(ModelState.IsValid)
            {
                string userId = User.Identity.GetUserId();
                bool saved = false;
                saved = followUpsFactory.createNewFollowUp(newFollowUp,userId);
                if(saved == false)
                {
                    return View(newFollowUp);
                }
                else
                {
                    return RedirectToAction("Details",new { id = newFollowUp.report.Id });
                }
            }
            else
            {
                return View(newFollowUp);
            }
        }

        protected override void Dispose(bool disposing)
        {
            if(disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
